const slidePage = document.querySelector(".slidepage");
const firtNextBtn = document.querySelector(".nextBtn");
const prevBtnSec = document.querySelector(".prev-1");
const nextBtnSec = document.querySelector(".next-1");
const prevBtnThird = document.querySelector(".prev-2");
const submitBtn = document.querySelector(".btn[type='submit']");
const progressText = document.querySelectorAll(".step p");
const progressCheck = document.querySelectorAll(".step .check");
const bullet = document.querySelectorAll(".step .bullet");
let max = 3;
let current = 1;

function validateForm() {
    let isValid = true;

    const firstName = document.getElementById("firstName");
    if (firstName && !firstName.checkValidity()) {
        isValid = false;
        firstName.reportValidity();
    }

    const lastName = document.getElementById("lastName");
    if (lastName && !lastName.checkValidity()) {
        isValid = false;
        lastName.reportValidity();
    }

    const phoneNumber = document.getElementById("phoneNumber");
    if (phoneNumber && !phoneNumber.checkValidity()) {
        isValid = false;
        phoneNumber.reportValidity();
    }

    const deliveryAddress = document.getElementById("deliveryAddress");
    if (deliveryAddress && !deliveryAddress.checkValidity()) {
        isValid = false;
        deliveryAddress.reportValidity();
    }

    const postcode = document.getElementById("postcode");
    if (postcode && !postcode.checkValidity()) {
        isValid = false;
        postcode.reportValidity();
    }

    return isValid;
}

function validatePayment() {
    let isValid = true;

    const holdername = document.getElementById("holdername");
    if (holdername && !holdername.checkValidity()) {
        isValid = false;
        holdername.reportValidity();
    }

    const cardno = document.getElementById("cardno");
    if (cardno && !cardno.checkValidity()) {
        isValid = false;
        cardno.reportValidity();
    }

    const cvv = document.getElementById("cvv");
    if (cvv && !cvv.checkValidity()) {
        isValid = false;
        cvv.reportValidity();
    }

    return isValid;
}

firtNextBtn.addEventListener("click", function(event) {
    event.preventDefault();
    slidePage.style.marginLeft = "-25%";
    bullet[current - 1].classList.add("active");
    progressCheck[current - 1].classList.add("active");
    progressText[current - 1].classList.add("active");
    current += 1;
});

nextBtnSec.addEventListener("click", function(event) {
    event.preventDefault();
    if (validateForm()) {
        slidePage.style.marginLeft = "-50%";
        bullet[current - 1].classList.add("active");
        progressCheck[current - 1].classList.add("active");
        progressText[current - 1].classList.add("active");
        current += 1;
    }
    else{
		 slidePage.style.marginLeft = "-25%";
	}
});

submitBtn.addEventListener("click", function() {
    if (validatePayment()) {
        bullet[current - 1].classList.add("active");
        progressCheck[current - 1].classList.add("active");
        progressText[current - 1].classList.add("active");
        current += 1;
    }
});

prevBtnSec.addEventListener("click", function(event) {
    event.preventDefault();
    slidePage.style.marginLeft = "0%";
    bullet[current - 2].classList.remove("active");
    progressCheck[current - 2].classList.remove("active");
    progressText[current - 2].classList.remove("active");
    current -= 1;
});

prevBtnThird.addEventListener("click", function(event) {
    event.preventDefault();
    slidePage.style.marginLeft = "-25%";
    bullet[current - 2].classList.remove("active");
    progressCheck[current - 2].classList.remove("active");
    progressText[current - 2].classList.remove("active");
    current -= 1;
});


//const phoneNumInput = document.getElementById("phomeNum");
//const phoneNumHelpBlock = document.getElementById("phoneNumHelpBlock");
//const postcodeInput = document.getElementById("postcode");
//const postcodeHelpBlock = document.getElementById("postcodeHelpBlock");
//const cardnumInput = document.getElementById("cardnum");
//const cardnumHelpBlock = document.getElementById("cardnumHelpBlock");
//const cvvInput = document.getElementById("cvv");
//const cvvHelpBlock = document.getElementById("cvvHelpBlock");
//
//const checkPostcode = (str) => {
//
//	const pattern = /^[0][]{10,15}*$/;
//    
//    return str.match(pattern);
//
//};
//
//const checkTwoDecimalPlaces = (str) => {
//
//	const pattern = /^[1-9][0-9]*([\.][0-9]{2})*$/;
//    
//    return str.match(pattern);
//
//};
//
//const checkDescription = (str) => {
//	
//	const min = 10;
//	const max = 200;
//	const len = str.split(" ").length;
//	
//	if (len < min || len > max){
//		return null;
//	} else {
//		return true;
//	}
//};