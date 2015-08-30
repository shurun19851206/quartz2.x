<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<script type="text/javascript">
			function onload () {
				// alert(window.document.location.pathname);
				// alert(window.document.location.pathname.substring(0,window.document.location.pathname.substr(1).indexOf('/')+1));
				var webPath = window.document.location.pathname;
				var path = webPath.substring(0, webPath.substr(1).indexOf('/')+1);
				
				document.getElementById("stopTrigger").href=path+"/triggerController/stopTrigger.action";
				document.getElementById("startTrigger").href=path+"/triggerController/startTrigger.action";
			}
		</script>
	</head>
	<body onload="onload()">
		<div>
			<ul>
				<li><a id="stopTrigger" href="#">暂停</a></li>
			</ul>
			<ul>
				<li><a id="startTrigger" href="#">启动</a></li>
			</ul>
		</div>
	</body>
</html>