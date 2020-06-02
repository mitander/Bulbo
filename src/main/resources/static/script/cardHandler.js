
//addCard är funktionen som kallas vid addCard-onclick-event
//param: x = det i din clip-board om du har utfört ctrl-v

window.onload = function() {

	//Global-scope Definitions
	var addCardButton = document.getElementById('addNewCard');
	var confirmNewCard = document.getElementById('confirmNewCard');
	var declineNewCard = document.getElementById('declineNewCard');
	var showOverlay = document.getElementById('editableDiv');
	
	//Tie Events to Callbacks
	addCardButton.addEventListener('click', handleNewCard);
	confirmNewCard.addEventListener('click', handleConfirmCard);
	declineNewCard.addEventListener('click', handleDeclineCard);
	showOverlay.addEventListener('paste', handlePaste);
	
	function handleNewCard() {
		on();
	}
	
	function handleConfirmCard() {
		var title = document.getElementById("newCardTitle").value;
		var content = document.getElementById("newCardContent").value;
		
		addCard(title, content, getFormattedDate("DD:MM:YY"));
		off();
	}
	
	function handleDeclineCard() {
		off();
	}
	
	function addCard(title, content, date) {
		var parent = document.getElementById('cardContainer');
		
		var divCard = document.createElement('div');
		divCard.setAttribute('class', 'card');
		
		var divCardBody = document.createElement('div');
		divCardBody.setAttribute('class', 'card-body');
		
		var cardTitle = document.createElement('h5');
		cardTitle.setAttribute('class', 'card-title');
		cardTitle.innerHTML = title;
		
		var cardContent = document.createElement('p');
		cardContent.setAttribute('class', 'card-text');
		cardContent.innerHTML = content;
		
		var timeStamp = document.createElement('p');
		timeStamp.setAttribute('class', 'text-muted');
		timeStamp.innerHTML = date;
		
		divCardBody.appendChild(cardTitle);
		divCardBody.appendChild(cardContent);
		divCardBody.appendChild(timeStamp);
		divCard.appendChild(divCardBody);
		
		parent.insertBefore(divCard, document.getElementsByClassName('card')[0]);
	}
	
	function handlePaste(e) {
		var clipboardData;
		var pastedData;
	
		// Stop data actually being pasted into div
		e.stopPropagation();
		e.preventDefault();
	
		// Get pasted data via clipboard API
		clipboardData = e.clipboardData || window.clipboardData;
		pastedData = clipboardData.getData('Text');
	
		on();
		document.getElementById('newCardContent').value = pastedData;
	}
	
	function on() {
		document.getElementById("overlay").style.display = "block";
	}
	
	function off() {
		document.getElementById("newCardTitle").value = "";
		document.getElementById("newCardContent").value = "";
		document.getElementById("overlay").style.display = "none";
	}

}
