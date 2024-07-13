submitBtn.addEventListener("click", (event) => {
  
  const validWeight = weightInput.className.includes("is-valid");
  const validPrice = priceInput.className.includes("is-valid");
  const validStock = stockInput.className.includes("is-valid");
  const validDescription = descriptionInput.className.includes("is-valid");
  
  if (!validWeight || !validPrice || !validStock || !validDescription){
  	event.preventDefault();
  	alert("Ensure all inputs are provided correctly!");
  }

});
