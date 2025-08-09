const BASE_API_URL = '/api/v1/'

const MESSAGE = document.getElementById('message');

document.getElementById('registrationForm').addEventListener('submit', async function(event) {
    event.preventDefault();
    
    const form = event.target;
    const formData = new FormData(form);

    const data = {
        email: formData.get('email'),
        password: formData.get('password'),
        name: formData.get('name'),
        role: formData.get('role')
    };

    let url;
    if (data.role === 'USER') {
        url = BASE_API_URL + 'users';
    } else if (data.role === 'VENDOR') {
        url = BASE_API_URL + 'vendors';
    } else {
        MESSAGE.textContent = 'Пожалуйста, выберите роль';
        return;
    }
    
    try {
        const response = await fetch(url, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(data)
        });

        if (response.ok) {
            MESSAGE.textContent = 'Регистрация прошла успешно';
        } else {
            const errorData = await response.json();
            MESSAGE.textContent = 'Ошибка: ' + (errorData.message || response.statusText);
        }
    } catch (error) {
        MESSAGE.textContent = 'Ошибка сети: ' + error.message;
    }
});