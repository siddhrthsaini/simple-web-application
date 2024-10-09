document.getElementById('contactForm').addEventListener('submit', function (event) {
    event.preventDefault();

    const inputData = {
        "name": document.getElementById('name').value.trim(),
        "email": document.getElementById('email').value,
        "message": document.getElementById('message').value.trim()
    }

    let isValid = true;

    if (inputData.name === '') {
        document.getElementById('nameError').textContent = 'Name is required';
        document.getElementById('nameError').style.display = 'block';
        isValid = false;
    }

    var emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    if (inputData.email === '' || !emailPattern.test(inputData.email)) {
        document.getElementById('emailError').textContent = 'Valid email is required';
        document.getElementById('emailError').style.display = 'block';
        isValid = false;
    }

    if (inputData.message === '') {
        document.getElementById('messageError').textContent = 'Message is required';
        document.getElementById('messageError').style.display = 'block';
        isValid = false;
    }

    if (isValid) {
        console.log(inputData);
        const errorElements = document.querySelectorAll('.error-message');
        errorElements.forEach(el => el.style.display = 'none');
    }
});
