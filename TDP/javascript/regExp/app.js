const checkname = /^[a-zA-Z]{3,}$/;
const checkemail = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;
const checktelefono = /^\d{10}$/;
const checkbudget = /^\d+$/;


function validation() {

    const name = document.getElementById("name").value;
    const email = document.getElementById("email").value;
    const telefono = document.getElementById("telefono").value;
    const budget = document.getElementById("budget").value;

    if (!checkname.test(name)) {
        document.getElementById("errNominativo").innerHTML = "Il nome deve contenere almeno 3 lettere.";
    }
    if (!checkemail.test(email)) {
        document.getElementById("errEmail").innerHTML = "L'email non è valida.";
    }
    if (!checktelefono.test(telefono)) {
        document.getElementById("errTelefono").innerHTML = "Il numero di telefono deve contenere esattamente 10 cifre.";
    }
    if (!checkbudget.test(budget)) {
        document.getElementById("errBudget").innerHTML = "Il budget deve essere un numero positivo.";
    }
    
    // selezione di ogni servizio e verifica se almeno uno è selezionato
    const services = document.querySelectorAll(".service");
    let serviceSelected = false;
    services.forEach(service => {
        if (service.checked) {
            serviceSelected = true;

        }
    });
    if (!serviceSelected) {
        document.getElementById("errServizi").innerHTML = "Seleziona almeno un servizio.";
    }
}

function calculateBudget() {

    const services = document.querySelectorAll(".service");
    let total = 0;

    services.forEach(service => {
        if (service.checked) {
            const rate = Number(service.dataset.rate) || 0;
            const hoursId = "h_" + service.id.substring(2); // s_html -> h_html
            const hoursEl = document.getElementById(hoursId);
            const hours = Math.max(0, Number(hoursEl?.value) || 0);
            total += rate * hours;
        }
    });

    document.getElementById("total").textContent = `€${total.toFixed(2)}`;
    return total;
}

// abilita/disabilita input ore quando si seleziona un servizio e ricalcola al volo
const serviceCheckboxes = document.querySelectorAll('.service');
serviceCheckboxes.forEach(cb => {
    cb.addEventListener('change', () => {
        const hoursEl = document.getElementById('h_' + cb.id.substring(2));
        if (cb.checked) {
            hoursEl.disabled = false;
            if (!hoursEl.value) hoursEl.value = 1; // valore iniziale utile
        } else {
            hoursEl.disabled = true;
            hoursEl.value = '';
        }
        calculateBudget();
    });
});

// ricalcola quando cambiano le ore
const hoursInputs = document.querySelectorAll('.hours');
hoursInputs.forEach(h => h.addEventListener('input', calculateBudget));