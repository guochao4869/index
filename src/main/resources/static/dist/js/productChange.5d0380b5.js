(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["productChange"],{1276:function(t,e,i){"use strict";var s=i("d784"),o=i("44e7"),r=i("825a"),a=i("1d80"),n=i("4840"),l=i("8aa5"),c=i("50c4"),u=i("14c3"),d=i("9263"),f=i("d039"),h=[].push,p=Math.min,v=4294967295,m=!f((function(){return!RegExp(v,"y")}));s("split",2,(function(t,e,i){var s;return s="c"=="abbc".split(/(b)*/)[1]||4!="test".split(/(?:)/,-1).length||2!="ab".split(/(?:ab)*/).length||4!=".".split(/(.?)(.?)/).length||".".split(/()()/).length>1||"".split(/.?/).length?function(t,i){var s=String(a(this)),r=void 0===i?v:i>>>0;if(0===r)return[];if(void 0===t)return[s];if(!o(t))return e.call(s,t,r);var n,l,c,u=[],f=(t.ignoreCase?"i":"")+(t.multiline?"m":"")+(t.unicode?"u":"")+(t.sticky?"y":""),p=0,m=new RegExp(t.source,f+"g");while(n=d.call(m,s)){if(l=m.lastIndex,l>p&&(u.push(s.slice(p,n.index)),n.length>1&&n.index<s.length&&h.apply(u,n.slice(1)),c=n[0].length,p=l,u.length>=r))break;m.lastIndex===n.index&&m.lastIndex++}return p===s.length?!c&&m.test("")||u.push(""):u.push(s.slice(p)),u.length>r?u.slice(0,r):u}:"0".split(void 0,0).length?function(t,i){return void 0===t&&0===i?[]:e.call(this,t,i)}:e,[function(e,i){var o=a(this),r=void 0==e?void 0:e[t];return void 0!==r?r.call(e,o,i):s.call(String(o),e,i)},function(t,o){var a=i(s,t,this,o,s!==e);if(a.done)return a.value;var d=r(t),f=String(this),h=n(d,RegExp),g=d.unicode,b=(d.ignoreCase?"i":"")+(d.multiline?"m":"")+(d.unicode?"u":"")+(m?"y":"g"),w=new h(m?d:"^(?:"+d.source+")",b),y=void 0===o?v:o>>>0;if(0===y)return[];if(0===f.length)return null===u(w,f)?[f]:[];var C=0,L=0,x=[];while(L<f.length){w.lastIndex=m?L:0;var R,V=u(w,m?f:f.slice(L));if(null===V||(R=p(c(w.lastIndex+(m?0:L)),f.length))===C)L=l(f,L,g);else{if(x.push(f.slice(C,L)),x.length===y)return x;for(var A=1;A<=V.length-1;A++)if(x.push(V[A]),x.length===y)return x;L=C=R}}return x.push(f.slice(C)),x}]}),!m)},"159b":function(t,e,i){var s=i("da84"),o=i("fdbc"),r=i("17c2"),a=i("9112");for(var n in o){var l=s[n],c=l&&l.prototype;if(c&&c.forEach!==r)try{a(c,"forEach",r)}catch(u){c.forEach=r}}},"17c2":function(t,e,i){"use strict";var s=i("b727").forEach,o=i("a640"),r=i("ae40"),a=o("forEach"),n=r("forEach");t.exports=a&&n?[].forEach:function(t){return s(this,t,arguments.length>1?arguments[1]:void 0)}},"1dde":function(t,e,i){var s=i("d039"),o=i("b622"),r=i("2d00"),a=o("species");t.exports=function(t){return r>=51||!s((function(){var e=[],i=e.constructor={};return i[a]=function(){return{foo:1}},1!==e[t](Boolean).foo}))}},4160:function(t,e,i){"use strict";var s=i("23e7"),o=i("17c2");s({target:"Array",proto:!0,forced:[].forEach!=o},{forEach:o})},"65f0":function(t,e,i){var s=i("861d"),o=i("e8b5"),r=i("b622"),a=r("species");t.exports=function(t,e){var i;return o(t)&&(i=t.constructor,"function"!=typeof i||i!==Array&&!o(i.prototype)?s(i)&&(i=i[a],null===i&&(i=void 0)):i=void 0),new(void 0===i?Array:i)(0===e?0:e)}},8418:function(t,e,i){"use strict";var s=i("c04e"),o=i("9bf2"),r=i("5c6c");t.exports=function(t,e,i){var a=s(e);a in t?o.f(t,a,r(0,i)):t[a]=i}},"921a":function(t,e,i){},a15b:function(t,e,i){"use strict";var s=i("23e7"),o=i("44ad"),r=i("fc6a"),a=i("a640"),n=[].join,l=o!=Object,c=a("join",",");s({target:"Array",proto:!0,forced:l||!c},{join:function(t){return n.call(r(this),void 0===t?",":t)}})},a194:function(t,e,i){"use strict";i("921a")},a434:function(t,e,i){"use strict";var s=i("23e7"),o=i("23cb"),r=i("a691"),a=i("50c4"),n=i("7b0b"),l=i("65f0"),c=i("8418"),u=i("1dde"),d=i("ae40"),f=u("splice"),h=d("splice",{ACCESSORS:!0,0:0,1:2}),p=Math.max,v=Math.min,m=9007199254740991,g="Maximum allowed length exceeded";s({target:"Array",proto:!0,forced:!f||!h},{splice:function(t,e){var i,s,u,d,f,h,b=n(this),w=a(b.length),y=o(t,w),C=arguments.length;if(0===C?i=s=0:1===C?(i=0,s=w-y):(i=C-2,s=v(p(r(e),0),w-y)),w+i-s>m)throw TypeError(g);for(u=l(b,s),d=0;d<s;d++)f=y+d,f in b&&c(u,d,b[f]);if(u.length=s,i<s){for(d=y;d<w-s;d++)f=d+s,h=d+i,f in b?b[h]=b[f]:delete b[h];for(d=w;d>w-s+i;d--)delete b[d-1]}else if(i>s)for(d=w-s;d>y;d--)f=d+s-1,h=d+i-1,f in b?b[h]=b[f]:delete b[h];for(d=0;d<i;d++)b[d+y]=arguments[d+2];return b.length=w-s+i,u}})},adc7:function(t,e,i){"use strict";var s=function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("div",{staticClass:"left"},[i("ul",[t._l(t.leftArr,(function(e,s){return i("li",{key:e.id,class:{active:s==t.curid}},[i("svg",{staticClass:"icon",attrs:{"aria-hidden":"true"}},[i("use",{attrs:{"xlink:href":e.img}})]),i("router-link",{attrs:{to:e.url}},[t._v(t._s(e.name))])],1)})),i("li",{class:{active:6==t.curid},on:{click:t.pull}},[i("svg",{staticClass:"icon",attrs:{"aria-hidden":"true"}},[i("use",{attrs:{"xlink:href":"#icon-banner"}})]),i("div",{staticClass:"pull-btn"},[t._v("轮播图管理")]),i("i",{staticClass:"el-icon-caret-bottom",class:{pull:t.isPull}}),t.visible?i("div",{staticClass:"other",class:{changeHeight:t.isPull}},[i("p",{on:{click:function(e){return e.stopPropagation(),t.changeClassify(1)}}},[t._v("首页轮播")]),i("p",{on:{click:function(e){return e.stopPropagation(),t.changeClassify(2)}}},[t._v("产品轮播")])]):i("div",{staticClass:"other",class:{changeHeight:t.isPull}},[i("router-link",{attrs:{to:{path:"/banner",query:{id:1}}}},[t._v("首页轮播")]),i("router-link",{attrs:{to:{path:"/banner",query:{id:2}}}},[t._v("产品轮播")])],1)])],2)])},o=[],r={name:"Left",data:function(){return{leftArr:[{name:"产品管理",img:"#icon-chanpin1",num:"0",url:"/product"},{name:"新闻管理",img:"#icon-xinwen",num:"1",url:"/news"},{name:"专利管理",img:"#icon-zhuanli",num:"2",url:"/patent"},{name:"荣誉管理",img:"#icon-rongyu",num:"3",url:"/honor"},{name:"活动管理",img:"#icon-huodong",num:"4",url:"/activity"}]}},props:["curid","isPull","visible"],methods:{pull:function(){this.$emit("pull")},changeClassify:function(t){this.$emit("change",t)}}},a=r,n=i("2877"),l=Object(n["a"])(a,s,o,!1,null,null,null);e["a"]=l.exports},b3e5:function(t,e,i){"use strict";i.r(e);var s=function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("div",{staticClass:"public"},[i("header-content"),i("div",{staticClass:"public-content"},[i("left",{attrs:{curid:t.curid,isPull:t.isPull},on:{pull:t.pull}}),i("div",{staticClass:"right"},[i("div",{staticClass:"right-content"},[i("div",{staticClass:"title"},[i("svg",{staticClass:"icon",attrs:{"aria-hidden":"true"}},[i("use",{attrs:{"xlink:href":"#icon-shouye"}})]),i("p",[t._v(" 你现在所在的位置是: "),i("span",[i("router-link",{attrs:{to:"/product"}},[t._v("产品管理")])],1),t._v(" / "),i("span",[t._v(t._s(t.title))])])]),i("div",{staticClass:"info"},[i("el-form",{ref:"info",staticClass:"pro-info",attrs:{model:t.info,rules:t.rules,"label-width":"180px"}},[i("el-form-item",{attrs:{label:"产品名称：",prop:"name"}},[i("el-input",{model:{value:t.info.name,callback:function(e){t.$set(t.info,"name",e)},expression:"info.name"}})],1),i("el-form-item",{attrs:{label:"产品小标题：",prop:"smallname"}},[i("el-input",{model:{value:t.info.smallname,callback:function(e){t.$set(t.info,"smallname",e)},expression:"info.smallname"}})],1),i("el-form-item",{attrs:{label:"分类：",prop:"classify"}},[i("el-select",{attrs:{placeholder:"请选择分类"},on:{change:t.selectChange},model:{value:t.info.classify,callback:function(e){t.$set(t.info,"classify",e)},expression:"info.classify"}},[i("el-option",{attrs:{label:"智慧阅读",value:"1"}}),i("el-option",{attrs:{label:"智能穿戴",value:"2"}}),i("el-option",{attrs:{label:"数据库",value:"3"}})],1)],1),i("el-form-item",{attrs:{label:"产品图片：",prop:"img"}},[i("el-upload",{staticClass:"avatar-uploader",attrs:{name:"imgfile",action:t.RespondURL.url+"Goodsparticulars/uploadimg","show-file-list":!1,"on-success":t.handleAvatarSuccess}},[t.productImg?i("img",{staticClass:"avatar",attrs:{src:t.productImg}}):i("i",{staticClass:"el-icon-plus avatar-uploader-icon"}),t.productImg?i("div",{staticClass:"delImg",on:{click:function(e){return e.stopPropagation(),t.productDel(e)}}},[i("i",{staticClass:"el-icon-circle-close"})]):t._e(),t.productImg?i("div",{staticClass:"revise"},[t._v(" 替换 "),i("i",{staticClass:"el-icon-copy-document"})]):t._e()])],1),i("el-form-item",{attrs:{label:"产品大小：",prop:"length"}},[i("el-input",{model:{value:t.info.length,callback:function(e){t.$set(t.info,"length",e)},expression:"info.length"}})],1),i("el-form-item",{attrs:{label:"产品描述：",prop:"result"}},[i("el-input",{attrs:{type:"textarea",rows:6},model:{value:t.info.result,callback:function(e){t.$set(t.info,"result",e)},expression:"info.result"}})],1),i("el-form-item",{attrs:{label:"产品展示图：",prop:"goodsshowimg"}},[i("el-upload",{staticClass:"p-uploader",attrs:{name:"imgfile",action:t.RespondURL.url+"Goodsparticulars/uploadimg","list-type":"picture-card","on-success":t.handleAvatarSuccess2,"file-list":t.fileList,"on-remove":t.showImgRemove}},[i("i",{staticClass:"el-icon-plus avatar-uploader-icon"})])],1),i("el-form-item",{attrs:{label:"产品展示图描述：",prop:"showimgdescribe"}},[i("el-input",{attrs:{type:"textarea",rows:6},model:{value:t.info.showimgdescribe,callback:function(e){t.$set(t.info,"showimgdescribe",e)},expression:"info.showimgdescribe"}})],1),i("el-form-item",{attrs:{label:"产品视频1："}},[i("el-input",{model:{value:t.videoArr.showVideoPath1,callback:function(e){t.$set(t.videoArr,"showVideoPath1",e)},expression:"videoArr.showVideoPath1"}}),i("el-upload",{staticClass:"video",attrs:{name:"video",action:t.RespondURL.url+"Goodsparticulars/uploadvideo","on-success":t.handleVideoSuccess1,"show-file-list":!1}},[i("el-button",{staticClass:"upload-btn",attrs:{type:"primary"}},[t._v("上传视频")])],1),t.videoArr.showVideoPath1?i("div",{staticClass:"video-box"},[i("video",{staticClass:"video-avatar",attrs:{src:t.videoArr.showVideoPath1,controls:"controls"}}),i("div",{staticClass:"delVideo",on:{click:function(e){return e.stopPropagation(),t.delVideo(1)}}},[i("i",{staticClass:"el-icon-circle-close"})])]):t._e()],1),i("el-form-item",{attrs:{label:"产品视频2："}},[i("el-input",{model:{value:t.videoArr.showVideoPath2,callback:function(e){t.$set(t.videoArr,"showVideoPath2",e)},expression:"videoArr.showVideoPath2"}}),i("el-upload",{staticClass:"video",attrs:{name:"video",action:t.RespondURL.url+"Goodsparticulars/uploadvideo","on-success":t.handleVideoSuccess2,"show-file-list":!1}},[i("el-button",{staticClass:"upload-btn",attrs:{type:"primary"}},[t._v("上传视频")])],1),t.videoArr.showVideoPath2?i("div",{staticClass:"video-box"},[i("video",{staticClass:"video-avatar",attrs:{src:t.videoArr.showVideoPath2,controls:"controls"}}),i("div",{staticClass:"delVideo",on:{click:function(e){return e.stopPropagation(),t.delVideo(2)}}},[i("i",{staticClass:"el-icon-circle-close"})])]):t._e()],1),i("el-form-item",{attrs:{label:"视频描述：",prop:"videodescribe"}},[i("el-input",{attrs:{type:"textarea",rows:6},model:{value:t.info.videodescribe,callback:function(e){t.$set(t.info,"videodescribe",e)},expression:"info.videodescribe"}})],1)],1),i("div",{staticClass:"btn"},[i("el-button",{attrs:{type:"primary"},on:{click:t.submitForm}},[t._v("立即发送")]),i("el-button",{on:{click:function(e){return t.resetForm("info")}}},[t._v("取消重置")])],1)],1)])])],1)],1)},o=[],r=(i("4160"),i("a15b"),i("a434"),i("ac1f"),i("1276"),i("159b"),i("b592")),a=i("adc7"),n={name:"ProductChange",components:{Left:a["a"],HeaderContent:r["a"]},created:function(){var t=this;if(this.$route.query.id){this.title="产品修改";var e=this.$route.query.id;this.id=e,this.$ajax.get(this.RespondURL.url+"Goodsparticulars/findgoods/"+e).then((function(e){console.log(e);var i=e.data.result.classify;if(t.sort=i,e.data.result.classify=t.classifyArr[i-1],t.info=e.data.result,t.productImg=t.RespondURL.url+e.data.result.img,e.data.result.goodsshowimg){var s=e.data.result.goodsshowimg.split(";");s.forEach((function(e){t.productShowArray.push(e),t.fileList.push({url:t.RespondURL.url+e})}))}console.log(t.fileList),e.data.result.video&&(t.showVideoPath=t.RespondURL.url+e.data.result.video);var o=e.data.result.video.split(";");o.forEach((function(e,i){var s=i+1;t.videoArr["showVideoPath"+s]=""==e?e:t.RespondURL.url+e,t.resVideo["video"+s]=e}))}))}else this.title="添加产品"},data:function(){return{curid:"0",title:"",classifyArr:["智慧阅读","智能穿戴","数据库"],stateArr:["下架","上架"],id:"",sort:"",productShowArray:[],fileList:[],info:{name:"",smallname:"",classify:"",img:"",length:"",result:"",video:"",videodescribe:"",goodsshowimg:"",showimgdescribe:"",goodsshowname:"产品展示"},rules:{name:[{required:!0,message:"请输入产品名称",trigger:"blur"}],classify:[{required:!0,message:"请选择分类",trigger:"blur"}]},productImg:"",isPull:!1,showVideoPath:"",videoArr:{showVideoPath1:"",showVideoPath2:""},resVideo:{video1:"",video2:""}}},methods:{pull:function(){this.isPull?this.isPull=!1:this.isPull=!0},handleAvatarSuccess:function(t){this.productImg=this.RespondURL.url+t.result,this.info.img=t.result},handleAvatarSuccess2:function(t){console.log(t),this.fileList.push({url:this.RespondURL.url+t.result}),this.productShowArray.push(t.result),this.info.goodsshowimg=t.result},showImgRemove:function(t){var e=this;this.fileList.forEach((function(i,s){if(i.uid==t.uid){var o={fileurl:[e.productShowArray[s]]};e.fileList.splice(s,1),e.productShowArray.splice(s,1),e.$ajax.post(e.RespondURL.url+"setmeal/deletefile",o).then((function(t){console.log(t),t.data.flag&&(e.info.goodsshowimg="")}))}}))},selectChange:function(t){this.sort=t},productDel:function(){var t=this;this.productImg="";var e={fileurl:[this.info.img]};this.$ajax.post(this.RespondURL.url+"setmeal/deletefile",e).then((function(e){e.data.flag&&(t.info.img="")}))},submitForm:function(){var t=this;this.$refs.info.validate((function(e){if(!e)return t.$alert("发送失败，请内容填写完整","提示",{confirmButtonText:"确定",callback:function(){}}),!1;t.info.goodsshowimg=t.productShowArray.join(";");var i="";""==t.id?i=t.RespondURL.url+"Goodsparticulars/insertgoodssparticulars":(t.info.id=t.id[0],t.info.classify=t.sort,i=t.RespondURL.url+"Goodsparticulars/updategoodssparticulars"),t.info.video=t.resVideo.video1+";"+t.resVideo.video2,t.$ajax.post(i,t.info).then((function(e){t.info.classify=t.classifyArr[t.sort-1],t.$alert(e.data.describe,"提示",{confirmButtonText:"确定",callback:function(){e.data.flag&&t.$router.push("/product")}})}))}))},resetForm:function(){this.info={name:"",smallname:"",classify:"",img:"",length:"",result:"",video:"",videodescribe:"",goodsshowimg:"",showimgdescribe:"",goodsshowname:"产品展示"},this.productImg="",this.showVideoPath="",this.fileList=[]},handleVideoSuccess1:function(t){this.videoArr.showVideoPath1=this.RespondURL.url+t.result,this.resVideo.video1=t.result},handleVideoSuccess2:function(t){this.videoArr.showVideoPath2=this.RespondURL.url+t.result,this.resVideo.video2=t.result},delVideo:function(t){var e=this,i={};1==t?(this.videoArr.showVideoPath1="",i={fileurl:[this.resVideo.video1]}):(this.videoArr.showVideoPath2="",i={fileurl:[this.resVideo.video2]}),this.$ajax.post(this.RespondURL.url+"setmeal/deletefile",i).then((function(i){1==t?e.resVideo.video1="":e.resVideo.video2="",console.log(i)}))}}},l=n,c=(i("a194"),i("2877")),u=Object(c["a"])(l,s,o,!1,null,null,null);e["default"]=u.exports},b592:function(t,e,i){"use strict";var s=function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("div",{staticClass:"header"},[i("p",[t._v("人信官网管理系统")]),i("div",{staticClass:"header-right"},[i("ul",[i("li",{on:{click:t.reset}},[i("i",{staticClass:"el-icon-refresh"}),i("span",[t._v("刷新")])]),i("li",{on:{click:t.toLogin}},[i("i",{staticClass:"el-icon-refresh-left"}),i("span",[t._v("注销")])])])])])},o=[],r={name:"HeaderContent",data:function(){return{}},props:[],methods:{reset:function(){this.$router.go(0)},toLogin:function(){sessionStorage.removeItem("cookie"),this.setCookie("mycookid"," ",-1),this.$router.push("/")},setCookie:function(t,e,i){if(0!==i){var s=24*i*60*60*1e3,o=new Date(+new Date+s);document.cookie=t+"="+e+";expires="+o.toUTCString()+"; domain=192.168.10.75; path=/"}else document.cookie=t+"="+e}}},a=r,n=i("2877"),l=Object(n["a"])(a,s,o,!1,null,null,null);e["a"]=l.exports},b727:function(t,e,i){var s=i("0366"),o=i("44ad"),r=i("7b0b"),a=i("50c4"),n=i("65f0"),l=[].push,c=function(t){var e=1==t,i=2==t,c=3==t,u=4==t,d=6==t,f=7==t,h=5==t||d;return function(p,v,m,g){for(var b,w,y=r(p),C=o(y),L=s(v,m,3),x=a(C.length),R=0,V=g||n,A=e?V(p,x):i||f?V(p,0):void 0;x>R;R++)if((h||R in C)&&(b=C[R],w=L(b,R,y),t))if(e)A[R]=w;else if(w)switch(t){case 3:return!0;case 5:return b;case 6:return R;case 2:l.call(A,b)}else switch(t){case 4:return!1;case 7:l.call(A,b)}return d?-1:c||u?u:A}};t.exports={forEach:c(0),map:c(1),filter:c(2),some:c(3),every:c(4),find:c(5),findIndex:c(6),filterOut:c(7)}},e8b5:function(t,e,i){var s=i("c6b6");t.exports=Array.isArray||function(t){return"Array"==s(t)}},fdbc:function(t,e){t.exports={CSSRuleList:0,CSSStyleDeclaration:0,CSSValueList:0,ClientRectList:0,DOMRectList:0,DOMStringList:0,DOMTokenList:1,DataTransferItemList:0,FileList:0,HTMLAllCollection:0,HTMLCollection:0,HTMLFormElement:0,HTMLSelectElement:0,MediaList:0,MimeTypeArray:0,NamedNodeMap:0,NodeList:1,PaintRequestList:0,Plugin:0,PluginArray:0,SVGLengthList:0,SVGNumberList:0,SVGPathSegList:0,SVGPointList:0,SVGStringList:0,SVGTransformList:0,SourceBufferList:0,StyleSheetList:0,TextTrackCueList:0,TextTrackList:0,TouchList:0}}}]);
//# sourceMappingURL=productChange.5d0380b5.js.map