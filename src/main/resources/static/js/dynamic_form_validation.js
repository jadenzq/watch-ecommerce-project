const weightInput = document.getElementById("weight");
const weightHelpBlock = document.getElementById("weightHelpBlock");
const priceInput = document.getElementById("price");
const priceHelpBlock = document.getElementById("priceHelpBlock");
const stockInput = document.getElementById("stock");
const stockHelpBlock = document.getElementById("stockHelpBlock");
const descriptionInput = document.getElementById("description");
const descriptionHelpBlock = document.getElementById("descriptionHelpBlock");

const imgBlock1 = document.getElementById("img-block-1");
const imgBlockDescription1 = document.getElementById("img-block-description-1");
const img1Input = document.getElementById("img1");
const imgBlockDisplay1 = document.getElementById("img-block-display-1");

const imgBlock2 = document.getElementById("img-block-2");
const imgBlockDescription2 = document.getElementById("img-block-description-2");
const img2Input = document.getElementById("img2");
const imgBlockDisplay2 = document.getElementById("img-block-display-2");

const imgBlock3 = document.getElementById("img-block-3");
const imgBlockDescription3 = document.getElementById("img-block-description-3");
const img3Input = document.getElementById("img3");
const imgBlockDisplay3 = document.getElementById("img-block-display-3");

const imgBlock4 = document.getElementById("img-block-4");
const imgBlockDescription4 = document.getElementById("img-block-description-4");
const img4Input = document.getElementById("img4");
const imgBlockDisplay4 = document.getElementById("img-block-display-4");

const submitBtn = document.getElementById("submit");


const checkImgFileInput = () => {
	
	if (img1Input.files.length == 0 || img2Input.files.length == 0 || img3Input.files.length == 0 || img4Input.files.length == 0)  {
		return null;
	} else {
		return true;
	}
}


const checkInteger = (str) => {

	const pattern = /^[1-9][0-9]*$/;
    
    return str.match(pattern);

};


const checkTwoDecimalPlaces = (str) => {

	const pattern = /^[1-9][0-9]*([\.][0-9]{2})*$/;
    
    return str.match(pattern);

};


const checkDescription = (str) => {
	
	const min = 10;
	const max = 200;
	const len = str.split(" ").length;
	
	if (len < min || len > max){
		return null;
	} else {
		return true;
	}
};


weightInput.addEventListener("keyup", (event) => {
	
	const validWeight = checkTwoDecimalPlaces(weightInput.value);
	
	if (!validWeight){
		weightInput.classList.remove("is-valid");
	    weightHelpBlock.classList.remove("valid-feedback");
	    weightHelpBlock.classList.remove("text-muted");
	    weightInput.classList.add("is-invalid");
	    weightHelpBlock.classList.add("invalid-feedback");
  	} else {
		weightInput.classList.remove("is-invalid");
	    weightHelpBlock.classList.remove("text-muted");
	    weightHelpBlock.classList.remove("invalid-feedback");
	    weightInput.classList.add("is-valid");
	    weightHelpBlock.classList.add("valid-feedback");
	}
});


priceInput.addEventListener("keyup", (event) => {
	
	const validPrice = checkTwoDecimalPlaces(priceInput.value);

	if (!validPrice){
	    priceInput.classList.remove("is-valid");
	    priceHelpBlock.classList.remove("valid-feedback");
	    priceHelpBlock.classList.remove("text-muted");
	    priceInput.classList.add("is-invalid");
	    priceHelpBlock.classList.add("invalid-feedback");
	} else {
		priceInput.classList.remove("is-invalid");
	    priceHelpBlock.classList.remove("text-muted");
	    priceHelpBlock.classList.remove("invalid-feedback");
	    priceInput.classList.add("is-valid");
	    priceHelpBlock.classList.add("valid-feedback");
	}
});


stockInput.addEventListener("keyup", (event) => {
	
	const validStock = checkInteger(stockInput.value);

	if (!validStock){
		event.preventDefault();
		stockInput.classList.remove("is-valid");
		stockHelpBlock.classList.remove("valid-feedback");
	    stockHelpBlock.classList.remove("text-muted");
	    stockInput.classList.add("is-invalid");
	    stockHelpBlock.classList.add("invalid-feedback");
	} else {
		stockInput.classList.remove("is-invalid");
	    stockHelpBlock.classList.remove("invalid-feedback");
	    stockHelpBlock.classList.remove("text-muted");
	    stockInput.classList.add("is-valid");
	    stockHelpBlock.classList.add("valid-feedback");	
	}
});


descriptionInput.addEventListener("keyup", (event) => {
	
	const validDescription = checkDescription(descriptionInput.value);
	
	if (!validDescription){
		descriptionInput.classList.remove("is-valid");
	    descriptionHelpBlock.classList.remove("valid-feedback");
	    descriptionHelpBlock.classList.remove("text-muted");
	    descriptionInput.classList.add("is-invalid");
	    descriptionHelpBlock.classList.add("invalid-feedback");
  	} else {
		descriptionInput.classList.remove("is-invalid");
	    descriptionHelpBlock.classList.remove("text-muted");
	    descriptionHelpBlock.classList.remove("invalid-feedback");
	    descriptionInput.classList.add("is-valid");
	    descriptionHelpBlock.classList.add("valid-feedback");
	}
});


// update img-blocks to display images users uploaded
img1Input.addEventListener("change", (event) => {
	
	imgBlock1.classList.add("valid-img");
	imgBlockDescription1.style.display = "none";
	imgBlockDisplay1.src = URL.createObjectURL(event.target.files[0])
});


img2Input.addEventListener("change", (event) => {
	
	imgBlock2.classList.add("valid-img");
	imgBlockDescription2.style.display = "none";
	imgBlockDisplay2.src = URL.createObjectURL(event.target.files[0])
});


img3Input.addEventListener("change", (event) => {
	
	imgBlock3.classList.add("valid-img");
	imgBlockDescription3.style.display = "none";
	imgBlockDisplay3.src = URL.createObjectURL(event.target.files[0])
});


img4Input.addEventListener("change", (event) => {
	
	imgBlock4.classList.add("valid-img");
	imgBlockDescription4.style.display = "none";
	imgBlockDisplay4.src = URL.createObjectURL(event.target.files[0])
});