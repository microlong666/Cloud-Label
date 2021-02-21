// DOM Elements
const time = document.getElementById('time'),
    greeting = document.getElementById('greeting')

// Options
const showAmPm = true;

// Show Time
function showTime() {
    let today = new Date(),
        hour = today.getHours(),
        min = today.getMinutes(),
        sec = today.getSeconds();

    // Set AM or PM
    const amPm = hour >= 12 ? 'PM' : 'AM';

    // 12hr Format
    hour = hour % 12 || 12;

    // Output Time
    time.innerHTML = `${hour}<span>:</span>${addZero(min)}<span>:</span>${addZero(
        sec
    )} ${showAmPm ? amPm : ''}`;

    setTimeout(showTime, 1000);
}

// Add Zeros
function addZero(n) {
    return (parseInt(n, 10) < 10 ? '0' : '') + n;
}

// Set Background and Greeting
function setBgGreet() {
    let today = new Date(),
        hour = today.getHours();

    switch (hour) {
        case 1:
        case 2:
            document.body.style.backgroundImage = "url('img/1.jpg')";
            greeting.textContent = '晚上';
            break;
        case 3:
        case 4:
            document.body.style.backgroundImage = "url('img/2.jpg')";
            greeting.textContent = '晚上';
            break;
        case 5:
        case 6:
            document.body.style.backgroundImage = "url('img/3.jpg')";
            greeting.textContent = '早上';
            break;
        case 7:
        case 8:
            document.body.style.backgroundImage = "url('img/5.jpg')";
            greeting.textContent = '早上';
            break;
        case 9:
        case 10:
            document.body.style.backgroundImage = "url('img/6.jpg')";
            greeting.textContent = '早上';
            break;
        case 11:
        case 12:
            document.body.style.backgroundImage = "url('img/7.jpg')";
            greeting.textContent = '中午';
            break;
        case 13:
        case 14:
            document.body.style.backgroundImage = "url('img/9.jpg')";
            greeting.textContent = '下午';
            break;
        case 15:
        case 16:
            document.body.style.backgroundImage = "url('img/10.jpg')";
            greeting.textContent = '下午';
            break;
        case 17:
        case 18:
            document.body.style.backgroundImage = "url('img/11.jpg')";
            greeting.textContent = '傍晚';
            break;
        case 19:
        case 20:
            document.body.style.backgroundImage = "url('img/13.jpg')";
            greeting.textContent = '晚上';
            break;
        case 21:
        case 22:
            document.body.style.backgroundImage = "url('img/14.jpg')";
            greeting.textContent = '晚上';
            break;
        case 23:
        case 0:
            document.body.style.backgroundImage = "url('img/15.jpg')";
            greeting.textContent = '晚上';
            break;
    }
}

window.onload = function () {
    // 每10秒刷新时间
    setInterval("showTime()", 10000);
    // 每30秒刷新背景
    setInterval("setBgGreet()", 30000);
}

// Run
showTime();
setBgGreet();
