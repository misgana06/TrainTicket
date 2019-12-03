
var ticketForm = document.getElementById("ticketForm");
var passengers = document.getElementById("passengers");
var another = document.getElementById("anotherPassenger");
var dateField = document.getElementById("date");

document.getElementById("numberOfPassengers").addEventListener("change", function(){
	document.getElementById("submit").style.display="block";
	passengers.innerHTML = "";
	var passengerCount = parseInt(this.options[this.selectedIndex].value);
	for (let i=0; i<passengerCount; i++) {
		passengers.innerHTML += `
			<label class="passengerNumber"><strong>Passenger ${i+1}</strong></label>
			<div class="passengerDetails">
				<div class="pRow">
					<label>Name:</label>
					<input class="inputField" type="text" name="pName" placeholder="Full Name" autocomplete="off" required />
				</div>
				<div class="pRow">
					<label>Age:</label>
					<input class="inputField" type="number" name="pAge" min="0" max="100" required />
				</div>
				<div class="pRow">
					<label>Gender:</label>
					<select class="inputField" required>
						<option value="0" selected disabled>Please Select</option>
						<option value="male">Male</option>
						<option value="female">Female</option>
						<option value="other">Other</option>
					</select>
				</div>
			</div>

			`
	}
});

document.getElementById("trains").addEventListener("change", function(){
	var today = new Date();
	var dd = String(today.getDate() + 1).padStart(2, '0');
	var mm = String(today.getMonth() + 1).padStart(2, '0');
	var yyyy = today.getFullYear();

	var minDate = yyyy + '-' + mm + '-' + dd;
	var maxDate = (yyyy + 1) + '-' + mm + '-' + dd;
	
	dateField.setAttribute("min", minDate);
	dateField.setAttribute("max", maxDate);
	dateField.disabled=false;
});

document.getElementById("date").addEventListener("change", function(){
	document.getElementById("numberOfPassengers").disabled=false;
});

document.getElementById("generate").addEventListener("click", function(){
	ticketForm.style.display = "flex";
	document.getElementById("welcome").style.display = "none";
});