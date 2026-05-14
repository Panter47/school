google.charts.load('current', {'packages': ['corechart']});
google.charts.setOnLoadCallback(startApp);

class FunzioneLineare {
    constructor() {
        this.key = 'lineare';
        this.label = 'Retta';
        this.paramDefs = [
            { key: 'm', label: 'm', value: 1, step: 0.1 },
            { key: 'q', label: 'q', value: 0, step: 0.1 }
        ];
    }

    evaluate(x, params) {
        return params.m * x + params.q;
    }
}

class FunzioneParabola {
    constructor() {
        this.key = 'parabola';
        this.label = 'Parabola';
        this.paramDefs = [
            { key: 'a', label: 'a', value: 1, step: 0.1 },
            { key: 'b', label: 'b', value: 0, step: 0.1 },
            { key: 'c', label: 'c', value: 0, step: 0.1 }
        ];
    }

    evaluate(x, params) {
        return params.a * x * x + params.b * x + params.c;
    }
}

class Grafico {
    constructor() {
        this.registry = {
            lineare: new FunzioneLineare(),
            parabola: new FunzioneParabola()
        };
        this.chart = new google.visualization.LineChart(document.getElementById('curve_chart'));
        this.bindEvents();
        this.renderParameterInputs();
        this.draw();
    }

    bindEvents() {
        var self = this;
        document.getElementById('function-select').addEventListener('change', function() {
            self.renderParameterInputs();
            self.draw();
        });
        document.getElementById('x-min').addEventListener('input', function() { self.draw(); });
        document.getElementById('x-max').addEventListener('input', function() { self.draw(); });
        document.getElementById('x-step').addEventListener('input', function() { self.draw(); });
        window.addEventListener('resize', function() { self.draw(); });
    }

    currentFunction() {
        var key = document.getElementById('function-select').value;
        return this.registry[key];
    }

    renderParameterInputs() {
        var fn = this.currentFunction();
        var self = this;
        var container = document.getElementById('function-params');
        container.innerHTML = '';

        for (var i = 0; i < fn.paramDefs.length; i++) {
            var def = fn.paramDefs[i];
            var label = document.createElement('label');
            label.textContent = def.label + ' ';

            var input = document.createElement('input');
            input.type = 'number';
            input.name = def.key;
            input.value = String(def.value);
            input.step = String(def.step);
            input.addEventListener('input', function() { self.draw(); });

            label.appendChild(input);
            container.appendChild(label);
        }
    }

    parseRange() {
        var xMin = Number(document.getElementById('x-min').value);
        var xMax = Number(document.getElementById('x-max').value);
        var step = Number(document.getElementById('x-step').value);

        if (isNaN(xMin) || isNaN(xMax) || isNaN(step)) throw new Error('Inserisci solo valori numerici.');
        if (step <= 0) throw new Error('Il passo deve essere maggiore di 0.');
        if (xMin >= xMax) throw new Error('x min deve essere minore di x max.');
        if ((xMax - xMin) / step > 3000) throw new Error('Troppi punti: aumenta il passo o riduci il range.');

        return { xMin: xMin, xMax: xMax, step: step };
    }

    readParams() {
        var fn = this.currentFunction();
        var params = {};
        var container = document.getElementById('function-params');

        for (var i = 0; i < fn.paramDefs.length; i++) {
            var def = fn.paramDefs[i];
            var input = container.querySelector('input[name="' + def.key + '"]');
            var value = Number(input.value);
            if (isNaN(value)) throw new Error('Parametro ' + def.label + ' non valido.');
            params[def.key] = value;
        }

        return params;
    }

    buildRows(fn, params, range) {
        var rows = [];
        for (var x = range.xMin; x <= range.xMax + range.step / 2; x += range.step) {
            rows.push([x, fn.evaluate(x, params)]);
        }
        return rows;
    }

    draw() {
        try {
            var fn = this.currentFunction();
            var range = this.parseRange();
            var params = this.readParams();
            var rows = this.buildRows(fn, params, range);

            var data = new google.visualization.DataTable();
            data.addColumn('number', 'x');
            data.addColumn('number', 'y');
            data.addRows(rows);

            var options = {
                title: fn.label,
                hAxis: { title: 'x' },
                vAxis: { title: 'y' },
                legend: 'none',
                curveType: 'none'
            };

            this.chart.draw(data, options);
            document.getElementById('message').innerHTML = '';
        } catch (error) {
            document.getElementById('message').innerHTML = error.message;
            var empty = new google.visualization.DataTable();
            empty.addColumn('number', 'x');
            empty.addColumn('number', 'y');
            this.chart.draw(empty, { title: 'Errore nei parametri', legend: 'none' });
        }
    }
}

function startApp() {
    new Grafico();
}