!function(a){"function"==typeof define&&define.amd?define(["jquery"],a):a(jQuery)}(function(a){var e={},f=Math.max,b=Math.min;e.c={},e.c.d=a(document),e.c.t=function(c){return c.originalEvent.touches.length-1},e.o=function(){var c=this;this.o=null,this.$=null,this.i=null,this.g=null,this.v=null,this.cv=null,this.x=0,this.y=0,this.w=0,this.h=0,this.$c=null,this.c=null,this.t=0,this.isInit=!1,this.fgColor=null,this.pColor=null,this.dH=null,this.cH=null,this.eH=null,this.rH=null,this.scale=1,this.relative=!1,this.relativeWidth=!1,this.relativeHeight=!1,this.$div=null,this.run=function(){var d=function(j,g){var h;for(h in g){c.o[h]=g[h]}c._carve().init(),c._configure()._draw()};if(!this.$.data("kontroled")){if(this.$.data("kontroled",!0),this.extend(),this.o=a.extend({min:void 0!==this.$.data("min")?this.$.data("min"):0,max:void 0!==this.$.data("max")?this.$.data("max"):100,stopper:!0,readOnly:this.$.data("readonly")||"readonly"===this.$.attr("readonly"),cursor:(!0===this.$.data("cursor")?30:this.$.data("cursor"))||0,thickness:this.$.data("thickness")&&Math.max(Math.min(this.$.data("thickness"),1),0.01)||0.35,lineCap:this.$.data("linecap")||"butt",width:this.$.data("width")||200,height:this.$.data("height")||200,displayInput:null==this.$.data("displayinput")||this.$.data("displayinput"),displayPrevious:this.$.data("displayprevious"),fgColor:this.$.data("fgcolor")||"#87CEEB",inputColor:this.$.data("inputcolor"),font:this.$.data("font")||"Arial",fontWeight:this.$.data("font-weight")||"bold",inline:!1,step:this.$.data("step")||1,rotation:this.$.data("rotation"),draw:null,change:null,cancel:null,release:null,format:function(g){return g},parse:function(g){return parseFloat(g)}},this.o),this.o.flip="anticlockwise"===this.o.rotation||"acw"===this.o.rotation,this.o.inputColor||(this.o.inputColor=this.o.fgColor),this.$.is("fieldset")?(this.v={},this.i=this.$.find("input"),this.i.each(function(g){var h=a(this);c.i[g]=h,c.v[g]=c.o.parse(h.val()),h.bind("change blur",function(){var i={};i[g]=h.val(),c.val(c._validate(i))})}),this.$.find("legend").remove()):(this.i=this.$,this.v=this.o.parse(this.$.val()),""===this.v&&(this.v=this.o.min),this.$.bind("change blur",function(){c.val(c._validate(c.o.parse(c.$.val())))})),!this.o.displayInput&&this.$.hide(),this.$c=a(document.createElement("canvas")).attr({width:this.o.width,height:this.o.height}),this.$div=a('<div style="'+(this.o.inline?"display:inline;":"")+"width:"+this.o.width+"px;height:"+this.o.height+'px;"></div>'),this.$.wrap(this.$div).before(this.$c),this.$div=this.$.parent(),"undefined"!=typeof G_vmlCanvasManager&&G_vmlCanvasManager.initElement(this.$c[0]),this.c=this.$c[0].getContext?this.$c[0].getContext("2d"):null,!this.c){throw {name:"CanvasNotSupportedException",message:"Canvas not supported. Please use excanvas on IE8.0.",toString:function(){return this.name+": "+this.message}}}return this.scale=(window.devicePixelRatio||1)/(this.c.webkitBackingStorePixelRatio||this.c.mozBackingStorePixelRatio||this.c.msBackingStorePixelRatio||this.c.oBackingStorePixelRatio||this.c.backingStorePixelRatio||1),this.relativeWidth=this.o.width%1!=0&&this.o.width.indexOf("%"),this.relativeHeight=this.o.height%1!=0&&this.o.height.indexOf("%"),this.relative=this.relativeWidth||this.relativeHeight,this._carve(),this.v instanceof Object?(this.cv={},this.copy(this.v,this.cv)):this.cv=this.v,this.$.bind("configure",d).parent().bind("configure",d),this._listen()._configure()._xy().init(),this.isInit=!0,this.$.val(this.o.format(this.v)),this._draw(),this}},this._carve=function(){if(this.relative){var g=this.relativeWidth?this.$div.parent().width()*parseInt(this.o.width)/100:this.$div.parent().width(),d=this.relativeHeight?this.$div.parent().height()*parseInt(this.o.height)/100:this.$div.parent().height();this.w=this.h=Math.min(g,d)}else{this.w=this.o.width,this.h=this.o.height}return this.$div.css({width:this.w+"px",height:this.h+"px"}),this.$c.attr({width:this.w,height:this.h}),1!==this.scale&&(this.$c[0].width=this.$c[0].width*this.scale,this.$c[0].height=this.$c[0].height*this.scale,this.$c.width(this.w),this.$c.height(this.h)),this},this._draw=function(){var d=!0;c.g=c.c,c.clear(),c.dH&&(d=c.dH()),!1!==d&&c.draw()},this._touch=function(g){var d=function(j){var h=c.xy2val(j.originalEvent.touches[c.t].pageX,j.originalEvent.touches[c.t].pageY);h!=c.cv&&(c.cH&&!1===c.cH(h)||(c.change(c._validate(h)),c._draw()))};return this.t=e.c.t(g),d(g),e.c.d.bind("touchmove.k",d).bind("touchend.k",function(){e.c.d.unbind("touchmove.k touchend.k"),c.val(c.cv)}),this},this._mouse=function(g){var d=function(j){var h=c.xy2val(j.pageX,j.pageY);h!=c.cv&&(c.cH&&!1===c.cH(h)||(c.change(c._validate(h)),c._draw()))};return d(g),e.c.d.bind("mousemove.k",d).bind("keyup.k",function(h){if(27===h.keyCode){if(e.c.d.unbind("mouseup.k mousemove.k keyup.k"),c.eH&&!1===c.eH()){return}c.cancel()}}).bind("mouseup.k",function(h){e.c.d.unbind("mousemove.k mouseup.k keyup.k"),c.val(c.cv)}),this},this._xy=function(){var d=this.$c.offset();return this.x=d.left,this.y=d.top,this},this._listen=function(){return this.o.readOnly?this.$.attr("readonly","readonly"):(this.$c.bind("mousedown",function(d){d.preventDefault(),c._xy()._mouse(d)}).bind("touchstart",function(d){d.preventDefault(),c._xy()._touch(d)}),this.listen()),this.relative&&a(window).resize(function(){c._carve().init(),c._draw()}),this},this._configure=function(){return this.o.draw&&(this.dH=this.o.draw),this.o.change&&(this.cH=this.o.change),this.o.cancel&&(this.eH=this.o.cancel),this.o.release&&(this.rH=this.o.release),this.o.displayPrevious?(this.pColor=this.h2rgba(this.o.fgColor,"0.4"),this.fgColor=this.h2rgba(this.o.fgColor,"0.6")):this.fgColor=this.o.fgColor,this},this._clear=function(){this.$c[0].width=this.$c[0].width},this._validate=function(g){var d=~~((g<0?-0.5:0.5)+g/this.o.step)*this.o.step;return Math.round(100*d)/100},this.listen=function(){},this.extend=function(){},this.init=function(){},this.change=function(d){},this.val=function(d){},this.xy2val=function(g,d){},this.draw=function(){},this.clear=function(){this._clear()},this.h2rgba=function(h,d){var g;return h=h.substring(1,7),"rgba("+(g=[parseInt(h.substring(0,2),16),parseInt(h.substring(2,4),16),parseInt(h.substring(4,6),16)])[0]+","+g[1]+","+g[2]+","+d+")"},this.copy=function(h,d){for(var g in h){d[g]=h[g]}}},e.Dial=function(){e.o.call(this),this.startAngle=null,this.xy=null,this.radius=null,this.lineWidth=null,this.cursorExt=null,this.w2=null,this.PI2=2*Math.PI,this.extend=function(){this.o=a.extend({bgColor:this.$.data("bgcolor")||"#EEEEEE",angleOffset:this.$.data("angleoffset")||0,angleArc:this.$.data("anglearc")||360,inline:!0},this.o)},this.val=function(d,c){if(null==d){return this.v}d=this.o.parse(d),!1!==c&&d!=this.v&&this.rH&&!1===this.rH(d)||(this.cv=this.o.stopper?f(b(d,this.o.max),this.o.min):d,this.v=this.cv,this.$.val(this.o.format(this.v)),this._draw())},this.xy2val=function(j,d){var g,c;return g=Math.atan2(j-(this.x+this.w2),-(d-this.y-this.w2))-this.angleOffset,this.o.flip&&(g=this.angleArc-g-this.PI2),this.angleArc!=this.PI2&&g<0&&-0.5<g?g=0:g<0&&(g+=this.PI2),c=g*(this.o.max-this.o.min)/this.angleArc+this.o.min,this.o.stopper&&(c=f(b(c,this.o.max),this.o.min)),c},this.listen=function(){var d,c,g,j,k=this,p=function(u){u.preventDefault();var o=u.originalEvent,r=o.detail||o.wheelDeltaX,l=o.detail||o.wheelDeltaY,q=k._validate(k.o.parse(k.$.val()))+(0<r||0<l?k.o.step:r<0||l<0?-k.o.step:0);q=f(b(q,k.o.max),k.o.min),k.val(q,!1),k.rH&&(clearTimeout(d),d=setTimeout(function(){k.rH(q),d=null},100),c||(c=setTimeout(function(){d&&k.rH(q),c=null},200)))},m=1,i={37:-k.o.step,38:k.o.step,39:k.o.step,40:-k.o.step};this.$.bind("keydown",function(n){var h=n.keyCode;if(96<=h&&h<=105&&(h=n.keyCode=h-48),g=parseInt(String.fromCharCode(h)),isNaN(g)&&(13!==h&&8!==h&&9!==h&&189!==h&&(190!==h||k.$.val().match(/\./))&&n.preventDefault(),-1<a.inArray(h,[37,38,39,40]))){n.preventDefault();var l=k.o.parse(k.$.val())+i[h]*m;k.o.stopper&&(l=f(b(l,k.o.max),k.o.min)),k.change(k._validate(l)),k._draw(),j=window.setTimeout(function(){m*=2},30)}}).bind("keyup",function(h){isNaN(g)?j&&(window.clearTimeout(j),j=null,m=1,k.val(k.$.val())):k.$.val()>k.o.max&&k.$.val(k.o.max)||k.$.val()<k.o.min&&k.$.val(k.o.min)}),this.$c.bind("mousewheel DOMMouseScroll",p),this.$.bind("mousewheel DOMMouseScroll",p)},this.init=function(){(this.v<this.o.min||this.v>this.o.max)&&(this.v=this.o.min),this.$.val(this.v),this.w2=this.w/2,this.cursorExt=this.o.cursor/100,this.xy=this.w2*this.scale,this.lineWidth=this.xy*this.o.thickness,this.lineCap=this.o.lineCap,this.radius=this.xy-this.lineWidth/2,this.o.angleOffset&&(this.o.angleOffset=isNaN(this.o.angleOffset)?0:this.o.angleOffset),this.o.angleArc&&(this.o.angleArc=isNaN(this.o.angleArc)?this.PI2:this.o.angleArc),this.angleOffset=this.o.angleOffset*Math.PI/180,this.angleArc=this.o.angleArc*Math.PI/180,this.startAngle=1.5*Math.PI+this.angleOffset,this.endAngle=1.5*Math.PI+this.angleOffset+this.angleArc;var c=f(String(Math.abs(this.o.max)).length,String(Math.abs(this.o.min)).length,2)+2;this.o.displayInput&&this.i.css({width:(this.w/2+4>>0)+"px",height:(this.w/3>>0)+"px",position:"absolute","vertical-align":"middle","margin-top":(this.w/3>>0)+"px","margin-left":"-"+(3*this.w/4+2>>0)+"px",border:0,background:"none",font:this.o.fontWeight+" "+(this.w/c>>0)+"px "+this.o.font,"text-align":"center",color:this.o.inputColor||this.o.fgColor,padding:"0px","-webkit-appearance":"none"})||this.i.css({width:"0px",visibility:"hidden"})},this.change=function(c){this.cv=c,this.$.val(this.o.format(c))},this.angle=function(c){return(c-this.o.min)*this.angleArc/(this.o.max-this.o.min)},this.arc=function(g){var c,d;return g=this.angle(g),d=this.o.flip?(c=this.endAngle+1e-05)-g-1e-05:(c=this.startAngle-1e-05)+g+1e-05,this.o.cursor&&(c=d-this.cursorExt)&&(d+=this.cursorExt),{s:c,e:d,d:this.o.flip&&!this.o.cursor}},this.draw=function(){var j,d=this.g,g=this.arc(this.cv),c=1;d.lineWidth=this.lineWidth,d.lineCap=this.lineCap,"none"!==this.o.bgColor&&(d.beginPath(),d.strokeStyle=this.o.bgColor,d.arc(this.xy,this.xy,this.radius,this.endAngle-1e-05,this.startAngle+1e-05,!0),d.stroke()),this.o.displayPrevious&&(j=this.arc(this.v),d.beginPath(),d.strokeStyle=this.pColor,d.arc(this.xy,this.xy,this.radius,j.s,j.e,j.d),d.stroke(),c=this.cv==this.v),d.beginPath(),d.strokeStyle=c?this.o.fgColor:this.fgColor,d.arc(this.xy,this.xy,this.radius,g.s,g.e,g.d),d.stroke()},this.cancel=function(){this.val(this.v)}},a.fn.dial=a.fn.knob=function(c){return this.each(function(){var d=new e.Dial;d.o=c,d.$=a(this),d.run()}).parent()}});