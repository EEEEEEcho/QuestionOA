$(function(){$(".sparkline-pie").sparkline("html",{type:"pie",offset:90,width:"150px",height:"150px",sliceColors:["#fb4364","#7868da","#3aaaec"]});drawDocSparklines();drawMouseSpeedDemo()});function drawDocSparklines(){$("#compositebar").sparkline("html",{type:"bar",barColor:"#aaf"});$("#compositebar").sparkline([4,1,5,7,9,9,8,7,6,6,4,7,8,4,3,2,2,5,6,7],{composite:true,fillColor:false,lineColor:"red"});$(".sparkline-1").sparkline();$(".largeline").sparkline("html",{type:"line",height:"2.5em",width:"4em"});$("#linecustom").sparkline("html",{height:"1.5em",width:"8em",lineColor:"#f00",fillColor:"#ffa",minSpotColor:false,maxSpotColor:false,spotColor:"#60bafd",spotRadius:3});$(".sparkbar").sparkline("html",{type:"bar"});$(".barformat").sparkline([1,3,5,3,8],{type:"bar",tooltipFormat:"{{value:levels}} - {{value}}",tooltipValueLookups:{levels:$.range_map({":2":"Low","3:6":"Medium","7:":"High"})}});$(".sparktristate").sparkline("html",{type:"tristate"});$(".sparktristatecols").sparkline("html",{type:"tristate",colorMap:{"-2":"#fa7","2":"#60bafd"}});$("#compositeline").sparkline("html",{fillColor:false,changeRangeMin:0,chartRangeMax:10});$("#compositeline").sparkline([4,1,5,7,9,9,8,7,6,6,4,7,8,4,3,2,2,5,6,7],{composite:true,fillColor:false,lineColor:"red",changeRangeMin:0,chartRangeMax:10});$("#normalline").sparkline("html",{fillColor:false,normalRangeMin:-1,normalRangeMax:8});$("#normalExample").sparkline("html",{fillColor:false,normalRangeMin:80,normalRangeMax:95,normalRangeColor:"#60bafd"});$(".discrete1").sparkline("html",{type:"discrete",lineColor:"#1ab1e3",xwidth:18});$("#discrete2").sparkline("html",{type:"discrete",lineColor:"#1ab1e3",thresholdColor:"red",thresholdValue:4});$(".sparkbullet").sparkline("html",{type:"bullet"});$(".sparkpie").sparkline("html",{type:"pie",height:"2em"});$(".sparkboxplot").sparkline("html",{type:"box"});$(".sparkboxplotraw").sparkline([1,3,5,8,10,15,18],{type:"box",raw:true,showOutliers:true,target:6});$(".boxfieldorder").sparkline("html",{type:"box",tooltipFormatFieldlist:["med","lq","uq"],tooltipFormatFieldlistKey:"field"});$(".clickdemo").sparkline();$(".clickdemo").bind("sparklineClick",function(a){var c=a.sparklines[0],b=c.getCurrentRegionFields();value=b.y;alert("Clicked on x="+b.x+" y="+b.y)});$(".mouseoverdemo").sparkline();$(".mouseoverdemo").bind("sparklineRegionChange",function(a){var c=a.sparklines[0],b=c.getCurrentRegionFields();value=b.y;$(".mouseoverregion").text("x="+b.x+" y="+b.y)}).bind("mouseleave",function(){$(".mouseoverregion").text("")})}function drawMouseSpeedDemo(){var h=500;var b=-1;var c=-1;var a;var e=0;var f=[];var g=30;$("html").mousemove(function(i){var j=i.pageX;var k=i.pageY;if(b>-1){e+=Math.max(Math.abs(j-b),Math.abs(k-c))}b=j;c=k});var d=function(){var i=new Date();var k=i.getTime();if(a&&a!=k){var j=Math.round(e/(k-a)*1000);f.push(j);if(f.length>g){f.splice(0,1)}e=0;$("#mousespeed").sparkline(f,{width:f.length*2,tooltipSuffix:" pixels per second"})}a=k;setTimeout(d,h)};setTimeout(d,h)}$("#sparkline14").sparkline([0,23,43,35,44,45,56,37,40,45,56,7,10],{type:"line",width:"100%",height:"100",lineColor:"#7868da",fillColor:"transparent",spotColor:"#fff",minSpotColor:undefined,maxSpotColor:undefined,highlightSpotColor:undefined,highlightLineColor:undefined});$("#sparkline16").sparkline([15,23,45,20,54,45,35,57,30],{type:"line",width:"100%",height:"100",chartRangeMax:50,resize:true,lineColor:"#51aaed",fillColor:"#60bafd",highlightLineColor:"rgba(0,0,0,.1)",highlightSpotColor:"rgba(0,0,0,.2)",});$("#sparkline16").sparkline([8,17,13,14,10,16,17,20,12,27],{type:"line",width:"100%",height:"100",chartRangeMax:40,lineColor:"#40c77c",fillColor:"#50d38a",composite:true,resize:true,highlightLineColor:"rgba(0,0,0,.1)",highlightSpotColor:"rgba(0,0,0,.2)",});