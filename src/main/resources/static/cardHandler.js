
//addCard är funktionen som kallas vid addCard-onclick-event
//param: x = det i din clip-board om du har utfört ctrl-v
function addCard(x) {
	
	//'referens' till vår cardContainer i HTML
	var cardContainer = document.getElementById('cardContainer');
	//skapa ett div-element
	var divCard = document.createElement('div');
	//tilldela klassen "card" till objektet ('card' är stilad från bootstrap)
	divCard.setAttribute('class', 'card');
	//skapa ett div-element
	var divCardBody = document.createElement('div');
	//tilldela klassen "card" till objektet ('card-body' är stilad från bootstrap)
	divCardBody.setAttribute('class', 'card-body');

	//skapa ett H5-element
	var titleH5 = document.createElement('h5');
	//card-title är från bootstrap
	titleH5.setAttribute('class', 'card-title');
	//tilldela värdet från newCardTitle i HTML till kortets H5
	if (document.getElementById('newCardTitle').value) {
		titleH5.innerHTML = document.getElementById('newCardTitle').value;
	} else {
		return;
	}
	//skapa ett p-element
	var cardContentP = document.createElement('p');
	//card-text är från bootstrap
	cardContentP.setAttribute('class', 'card-text');

	if (!x) {
		//om x är false, eller i javascripts fall, undefined
		//lagra det som finns i newCardContent
		var inputContent = document.getElementById('newCardContent').value;
		
		if (inputContent.startsWith("lorem")) {
			//OM DU SKRIVER loremx[antalord]
			var len = inputContent.split("x")[1];
			cardContentP.innerHTML = loremGenerator(len);
		}
		else {
			//annars tilldela newCardContent till kortets content
			if (inputContent)
				cardContentP.innerHTML = inputContent;
			else return;
		}
	} else {		
		//annars tilldela clipboard texten till kortets innehåll
		cardContentP.innerHTML = x;
	}
	
	var timeStamp = document.createElement('p');
	timeStamp.setAttribute('class', 'text-muted');

	//Ta reda på när kortet blev skapat
	var currentdate = new Date();
	var datetime = "Added: " + currentdate.getDate() + "/"
			+ (currentdate.getMonth() + 1) + "/" + currentdate.getFullYear()
			+ " @ " + currentdate.getHours() + ":" + currentdate.getMinutes();

	timeStamp.innerHTML = datetime;

	//appenda alla element till Parent: divCard
	divCardBody.appendChild(titleH5);
	divCardBody.appendChild(cardContentP);
	divCardBody.appendChild(timeStamp);
	divCard.appendChild(divCardBody);
	//lägg divCard först i workspacen.
	//document.getElementsByClassName('card') returnerar alla element i HTML
	//som har klassen: 'card' i en array.
	cardContainer.insertBefore(divCard,
			document.getElementsByClassName('card')[0]);
	
	//stäng av overlay
	off();

	//återställ input-fälten i overlay
	document.getElementById('newCardContent').value = "";
	document.getElementById('newCardTitle').value = "";
}

function loremGenerator(len) {

	var lorem = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean at enim pretium, ullamcorper purus quis, ornare tellus. Duis facilisis sit amet mauris sed egestas. Maecenas in lectus rutrum, scelerisque magna id, ullamcorper diam. Cras in dapibus ligula. Mauris vehicula, nibh quis auctor malesuada, justo erat egestas ipsum, vitae porttitor neque justo vitae justo. Nulla pharetra rutrum risus, sed consectetur nisl bibendum ut. Donec vestibulum, lorem id accumsan pulvinar, sapien tortor tempor lorem, non elementum sem dolor ac lorem. Maecenas eleifend odio non justo mattis pretium. Fusce lacinia posuere metus ac bibendum. Integer id malesuada augue. Nulla nec lacus in lacus dictum ornare. Praesent sit amet est est. Cras rhoncus, orci et volutpat malesuada, elit dolor volutpat velit, sit amet ornare erat purus vitae ante. Donec molestie laoreet imperdiet. Sed pharetra vitae lectus sit amet semper. Quisque euismod sem id malesuada iaculis. Suspendisse tincidunt faucibus turpis, in porttitor magna iaculis id. Vestibulum et orci sapien. Aliquam viverra, lacus id dignissim hendrerit, orci lorem ultricies leo, in posuere ex orci dictum odio. Fusce feugiat efficitur hendrerit. Phasellus efficitur tempor metus id laoreet. Integer vestibulum lectus et risus pharetra, non pretium lectus egestas. Aliquam mattis velit ut consectetur mattis. Praesent ullamcorper malesuada magna, id fermentum ante luctus nec. Nulla consequat ex id pharetra ullamcorper. Aliquam efficitur neque ut ante scelerisque iaculis. Ut laoreet posuere urna at pretium. Vestibulum nibh elit, bibendum a erat eu, elementum pretium dui. Duis in ullamcorper ante, vel maximus neque. Quisque a lorem dolor. Praesent ipsum tellus, vestibulum nec ipsum eget, finibus vehicula metus. Curabitur iaculis mattis quam. Nulla facilisi. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus et bibendum nibh. Sed fringilla suscipit tincidunt. Duis suscipit velit vel sem hendrerit, id porta metus mattis. Ut et volutpat sem. Cras id tristique odio. Interdum et malesuada fames ac."
	var loremList = lorem.split(" ");
	var generated = "";

	for (let x = 0; x < len; x++) {
		generated += loremList[x] + " ";
	}

	return generated;
}

function handlePaste(e) {
	//Inte min kod, är inte helt 100 på exakt vad detta gör, men litar på kommentarerna från min källa
	var clipboardData;
	var pastedData;

	// Stop data actually being pasted into div
	e.stopPropagation();
	e.preventDefault();

	// Get pasted data via clipboard API
	clipboardData = e.clipboardData || window.clipboardData;
	pastedData = clipboardData.getData('Text');

	//min kod
	//skapa kort med clipboard
	on();
	document.getElementById('newCardContent').value = pastedData;
}

//anropas när addBtn klickas
function on() {
	document.getElementById("overlay").style.display = "block";
}

//anropas när overlay ska stängas
function off() {
	document.getElementById("overlay").style.display = "none";
}

//lägg en paste-eventHandler på editableDiv
document.getElementById('editableDiv').addEventListener('paste', handlePaste);
