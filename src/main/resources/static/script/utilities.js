

	function loremGenerator(len) {
	
		var lorem = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean at enim pretium, ullamcorper purus quis, ornare tellus. Duis facilisis sit amet mauris sed egestas. Maecenas in lectus rutrum, scelerisque magna id, ullamcorper diam. Cras in dapibus ligula. Mauris vehicula, nibh quis auctor malesuada, justo erat egestas ipsum, vitae porttitor neque justo vitae justo. Nulla pharetra rutrum risus, sed consectetur nisl bibendum ut. Donec vestibulum, lorem id accumsan pulvinar, sapien tortor tempor lorem, non elementum sem dolor ac lorem. Maecenas eleifend odio non justo mattis pretium. Fusce lacinia posuere metus ac bibendum. Integer id malesuada augue. Nulla nec lacus in lacus dictum ornare. Praesent sit amet est est. Cras rhoncus, orci et volutpat malesuada, elit dolor volutpat velit, sit amet ornare erat purus vitae ante. Donec molestie laoreet imperdiet. Sed pharetra vitae lectus sit amet semper. Quisque euismod sem id malesuada iaculis. Suspendisse tincidunt faucibus turpis, in porttitor magna iaculis id. Vestibulum et orci sapien. Aliquam viverra, lacus id dignissim hendrerit, orci lorem ultricies leo, in posuere ex orci dictum odio. Fusce feugiat efficitur hendrerit. Phasellus efficitur tempor metus id laoreet. Integer vestibulum lectus et risus pharetra, non pretium lectus egestas. Aliquam mattis velit ut consectetur mattis. Praesent ullamcorper malesuada magna, id fermentum ante luctus nec. Nulla consequat ex id pharetra ullamcorper. Aliquam efficitur neque ut ante scelerisque iaculis. Ut laoreet posuere urna at pretium. Vestibulum nibh elit, bibendum a erat eu, elementum pretium dui. Duis in ullamcorper ante, vel maximus neque. Quisque a lorem dolor. Praesent ipsum tellus, vestibulum nec ipsum eget, finibus vehicula metus. Curabitur iaculis mattis quam. Nulla facilisi. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus et bibendum nibh. Sed fringilla suscipit tincidunt. Duis suscipit velit vel sem hendrerit, id porta metus mattis. Ut et volutpat sem. Cras id tristique odio. Interdum et malesuada fames ac."
		var loremList = lorem.split(" ");
		var generated = "";
	
		for (let x = 0; x < len; x++) {
			generated += loremList[x] + " ";
		}
	
		return generated;
	}
	
	function getFormattedDate(formatting) {
		
		var today = new Date();
		
		var dd = today.getDate();
		var mm = today.getMonth()+1; 
		var yyyy = today.getFullYear();
		
		if (dd < 10) {
			dd = '0' + dd;
		}
		
		if (mm < 10) {
			mm = '0' + mm;
		}
		
		switch (formatting) {
			case "YY:MM:DD":
				return yyyy+"-"+mm+"-"+dd;
			case "DD:MM:YY":
				return dd+"-"+mm+"-"+yyyy;
			case "MM:DD:YY":
				return mm+"-"+dd+"-"+yyyy;
		}
	}
