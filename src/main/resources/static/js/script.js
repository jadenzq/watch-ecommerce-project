const weightInput = document.getElementById("weight");
const weightHelpBlock = document.getElementById("weightHelpBlock");
const priceInput = document.getElementById("price");
const priceHelpBlock = document.getElementById("priceHelpBlock");
const stockInput = document.getElementById("stock");
const stockHelpBlock = document.getElementById("stockHelpBlock");
const descriptionInput = document.getElementById("description");
const descriptionHelpBlock = document.getElementById("descriptionHelpBlock");
const imgFileInput = document.getElementById("imgFile");
const submitBtn = document.getElementById("submit");


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

const checkImgFile = (filename) => {
	
	const pattern = /\.(jpg|jpeg|png)$/i;

	return filename.match(pattern);
};


submitBtn.addEventListener("click", (event) => {
  
  const validWeight = checkTwoDecimalPlaces(weightInput.value);
  const validPrice = checkTwoDecimalPlaces(priceInput.value);
  const validStock = checkInteger(stockInput.value);
  const validDescription = checkDescription(descriptionInput.value);
  const validImgFileInput = checkImgFile(imgFileInput.files[0].name);
  
  if (!validWeight || !validPrice || !validStock || !validDescription || !validImgFileInput){
  	event.preventDefault();
  	
  	if (!validImgFileInput){
		alert("Image file must .jpeg .jpg .png only");
	}
  }

});


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
  
