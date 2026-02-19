const checkname = /^[a-zA-Z]{3,}$/;
const checkemail = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;
const checktelefono = /^\d{10}$/;
const checkbudget = /^\d+$/;

const nameInput     = document.getElementById("name");
const emailInput    = document.getElementById("email");
const telefonoInput = document.getElementById("telefono");
const budgetInput   = document.getElementById("budget");
const submitButton  = document.getElementById("submit-button");

function setError(id, message) {
    document.getElementById(id).innerHTML = message;
}

function validateName() {
    if (!checkname.test(nameInput.value)) setError("errNominativo", "Il nome deve contenere almeno 3 lettere.");
    else setError("errNominativo", "");
}
function validateEmail() {
    if (!checkemail.test(emailInput.value)) setError("errEmail", "L'email non è valida.");
    else setError("errEmail", "");
}
function validateTelefono() {
    if (!checktelefono.test(telefonoInput.value)) setError("errTelefono", "Il numero di telefono deve contenere esattamente 10 cifre.");
    else setError("errTelefono", "");
}
function validateBudget() {
    if (!checkbudget.test(budgetInput.value)) setError("errBudget", "Il budget deve essere un numero positivo.");
    else setError("errBudget", "");
}
function validateServizi() {
    const services = document.querySelectorAll(".service");
    const anyChecked = [...services].some(s => s.checked);
    if (!anyChecked) setError("errServizi", "Seleziona almeno un servizio.");
    else setError("errServizi", "");
    return anyChecked;
}

nameInput.addEventListener("input", validateName);
emailInput.addEventListener("input", validateEmail);
telefonoInput.addEventListener("input", validateTelefono);
budgetInput.addEventListener("input", validateBudget);
document.querySelectorAll(".service").forEach(cb => cb.addEventListener("change", validateServizi));

submitButton.addEventListener("click", function(event) {
    event.preventDefault();

    validateName();
    validateEmail();
    validateTelefono();
    validateBudget();
    validateServizi();

    const errorIds = ["errNominativo", "errEmail", "errTelefono", "errBudget", "errServizi"];
    const hasErrors = errorIds.some(id => document.getElementById(id).innerHTML !== "");

    if (!hasErrors) {
    document.getElementById("form-error").innerHTML = "";
    
    const total = calculateBudget();
    const budget = Number(budgetInput.value);
    
    if (budget >= total) {
        alert(`Budget sufficiente! Budget: €${budget.toFixed(2)} | Costo stimato: €${total.toFixed(2)}`);
    } else {
        alert(`Budget insufficiente! Budget: €${budget.toFixed(2)} | Costo stimato: €${total.toFixed(2)}`);
    }

} else {
    document.getElementById("form-error").innerHTML = "Impossibile inviare il form";
}
});

// abilita/disabilita input ore e ricalcola budget
document.querySelectorAll(".service").forEach(cb => {
    cb.addEventListener("change", () => {
        const h = document.getElementById("h_" + cb.id.substring(2));
        h.disabled = !cb.checked;
        h.value = cb.checked ? (h.value || 1) : "";
        calculateBudget();
    });
});

document.querySelectorAll(".hours").forEach(h => h.addEventListener("input", calculateBudget));

function calculateBudget() {
    const total = [...document.querySelectorAll(".service:checked")].reduce((sum, s) => {
        const hours = Math.max(0, Number(document.getElementById("h_" + s.id.substring(2))?.value) || 0);
        return sum + (Number(s.dataset.rate) || 0) * hours;
    }, 0);
    document.getElementById("total").textContent = `€${total.toFixed(2)}`;
    return total;
}