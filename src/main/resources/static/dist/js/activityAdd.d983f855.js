(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["activityAdd"],{"0845":function(t,e,i){"use strict";i.r(e);var n=function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("div",{staticClass:"public"},[i("header-content"),i("div",{staticClass:"public-content"},[i("left",{attrs:{curid:t.curid,isPull:t.isPull},on:{pull:t.pull}}),i("div",{staticClass:"right"},[i("div",{staticClass:"right-content"},[i("div",{staticClass:"title"},[i("svg",{staticClass:"icon",attrs:{"aria-hidden":"true"}},[i("use",{attrs:{"xlink:href":"#icon-shouye"}})]),i("p",[t._v(" 你现在所在的位置是: "),i("span",[i("router-link",{attrs:{to:"/activity"}},[t._v("活动管理")])],1),t._v(" / "),i("span",[t._v(t._s(t.title))])])]),i("div",{staticClass:"info"},[i("el-form",{ref:"info",staticClass:"pro-info",attrs:{model:t.info,rules:t.rules,"label-width":"180px"}},[i("el-form-item",{attrs:{label:"活动标题：",prop:"title"}},[i("el-input",{model:{value:t.info.title,callback:function(e){t.$set(t.info,"title",e)},expression:"info.title"}})],1),i("el-form-item",{attrs:{label:"活动封面：",prop:"img"}},[i("el-upload",{staticClass:"avatar-uploader",attrs:{name:"imgfile",action:t.RespondURL.url+"Goodsparticulars/uploadimg","show-file-list":!1,"on-success":t.handleAvatarSuccess}},[t.imageUrl?i("img",{staticClass:"avatar",attrs:{src:t.imageUrl}}):i("i",{staticClass:"el-icon-plus avatar-uploader-icon"}),t.imageUrl?i("div",{staticClass:"delImg",on:{click:function(e){e.stopPropagation(),t.imageUrl="",t.info.img=""}}},[i("i",{staticClass:"el-icon-circle-close"})]):t._e(),t.imageUrl?i("div",{staticClass:"revise"},[t._v(" 替换 "),i("i",{staticClass:"el-icon-copy-document"})]):t._e()])],1),i("el-form-item",{attrs:{label:"活动时间: ",prop:"starttime"}},[i("el-date-picker",{attrs:{type:"date",placeholder:"发布时间"},on:{change:t.dateChange},model:{value:t.info.starttime,callback:function(e){t.$set(t.info,"starttime",e)},expression:"info.starttime"}})],1),i("el-form-item",{staticClass:"content",attrs:{label:"活动内容",prop:"content"}},[i("div",{staticClass:"insert"},[i("el-upload",{staticClass:"insert-uploader",attrs:{name:"imgfile",action:t.RespondURL.url+"Goodsparticulars/uploadimg","show-file-list":!1,"on-success":t.getImg}},[i("el-button",{attrs:{type:"primary"}},[i("i",{staticClass:"el-icon-picture"})])],1)],1),i("div",{ref:"content",staticClass:"edit",attrs:{contenteditable:"true"},on:{blur:t.getContent}})])],1),i("div",{staticClass:"btn"},[i("el-button",{attrs:{type:"primary"},on:{click:t.submitForm}},[t._v("立即发送")]),i("el-button",{on:{click:t.resetForm}},[t._v("取消重置")])],1)],1)])])],1)],1)},a=[],s=(i("99af"),i("b592")),r=i("adc7"),o={name:"ActivityAdd",components:{Left:r["a"],HeaderContent:s["a"]},created:function(){var t=this;if(this.$route.query.id){this.title="活动修改";var e=this.$route.query.id;this.id=e,this.$ajax.get(this.RespondURL.url+"ActivityContent/findActivityContentAll/ "+e).then((function(e){t.info=e.data.result,t.$refs.content.innerHTML=e.data.result.content,t.imageUrl=t.RespondURL.url+e.data.result.img}))}else this.title="添加活动"},data:function(){return{curid:"4",title:"",id:"",info:{title:"",starttime:"",content:"",img:"",site:""},rules:{name:[{required:!0,message:"请输入活动标题",trigger:"blur"}],time:[{required:!0,message:"请输入活动时间",trigger:"blur"}]},imageUrl:"",isPull:!1}},methods:{pull:function(){this.isPull?this.isPull=!1:this.isPull=!0},addHTML:function(t){var e=window.getSelection();if(e.getRangeAt&&e.rangeCount){var i=e.getRangeAt(0);i.deleteContents();var n=document.createElement("div");n.innerHTML=t;var a,s,r=document.createDocumentFragment();while(a=n.firstChild)s=r.appendChild(a);i.insertNode(r),s&&(i=i.cloneRange(),i.setStartAfter(s),i.collapse(!0),e.removeAllRanges(),e.addRange(i))}},getContent:function(){this.info.content=this.$refs.content.innerHTML},getImg:function(t){var e='<img src="'.concat(this.RespondURL.url).concat(t.result,'" alt="">');this.addHTML(e)},handleAvatarSuccess:function(t){this.imageUrl=this.RespondURL.url+t.result,this.info.img=t.result},dateChange:function(t){var e=this.$moment(t).format("YYYY-MM-DD");this.info.starttime=e},submitForm:function(){var t=this;this.$refs.info.validate((function(e){if(!e)return t.$alert("发送失败，请内容填写完整","提示",{confirmButtonText:"确定",callback:function(){}}),!1;var i="";""==t.id?i=t.RespondURL.url+"ActivityContent/insertActivityContent":(t.info.id=t.id[0],i=t.RespondURL.url+"ActivityContent/updateActivityContent"),t.$ajax.post(i,t.info).then((function(e){t.$alert(e.data.describe,"提示",{confirmButtonText:"确定",callback:function(){e.data.flag&&t.$router.push("/activity")}})}))}))},resetForm:function(){this.info={title:"",starttime:"",content:"",img:"",site:""},this.$refs.content.innerHTML="",this.imageUrl=""}}},l=o,c=(i("ff67"),i("2877")),u=Object(c["a"])(l,n,a,!1,null,null,null);e["default"]=u.exports},"1dde":function(t,e,i){var n=i("d039"),a=i("b622"),s=i("2d00"),r=a("species");t.exports=function(t){return s>=51||!n((function(){var e=[],i=e.constructor={};return i[r]=function(){return{foo:1}},1!==e[t](Boolean).foo}))}},"1e71":function(t,e,i){},"65f0":function(t,e,i){var n=i("861d"),a=i("e8b5"),s=i("b622"),r=s("species");t.exports=function(t,e){var i;return a(t)&&(i=t.constructor,"function"!=typeof i||i!==Array&&!a(i.prototype)?n(i)&&(i=i[r],null===i&&(i=void 0)):i=void 0),new(void 0===i?Array:i)(0===e?0:e)}},8418:function(t,e,i){"use strict";var n=i("c04e"),a=i("9bf2"),s=i("5c6c");t.exports=function(t,e,i){var r=n(e);r in t?a.f(t,r,s(0,i)):t[r]=i}},"99af":function(t,e,i){"use strict";var n=i("23e7"),a=i("d039"),s=i("e8b5"),r=i("861d"),o=i("7b0b"),l=i("50c4"),c=i("8418"),u=i("65f0"),d=i("1dde"),f=i("b622"),m=i("2d00"),p=f("isConcatSpreadable"),v=9007199254740991,h="Maximum allowed index exceeded",g=m>=51||!a((function(){var t=[];return t[p]=!1,t.concat()[0]!==t})),C=d("concat"),b=function(t){if(!r(t))return!1;var e=t[p];return void 0!==e?!!e:s(t)},y=!g||!C;n({target:"Array",proto:!0,forced:y},{concat:function(t){var e,i,n,a,s,r=o(this),d=u(r,0),f=0;for(e=-1,n=arguments.length;e<n;e++)if(s=-1===e?r:arguments[e],b(s)){if(a=l(s.length),f+a>v)throw TypeError(h);for(i=0;i<a;i++,f++)i in s&&c(d,f,s[i])}else{if(f>=v)throw TypeError(h);c(d,f++,s)}return d.length=f,d}})},adc7:function(t,e,i){"use strict";var n=function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("div",{staticClass:"left"},[i("ul",[t._l(t.leftArr,(function(e,n){return i("li",{key:e.id,class:{active:n==t.curid}},[i("svg",{staticClass:"icon",attrs:{"aria-hidden":"true"}},[i("use",{attrs:{"xlink:href":e.img}})]),i("router-link",{attrs:{to:e.url}},[t._v(t._s(e.name))])],1)})),i("li",{class:{active:6==t.curid},on:{click:t.pull}},[i("svg",{staticClass:"icon",attrs:{"aria-hidden":"true"}},[i("use",{attrs:{"xlink:href":"#icon-banner"}})]),i("div",{staticClass:"pull-btn"},[t._v("轮播图管理")]),i("i",{staticClass:"el-icon-caret-bottom",class:{pull:t.isPull}}),t.visible?i("div",{staticClass:"other",class:{changeHeight:t.isPull}},[i("p",{on:{click:function(e){return e.stopPropagation(),t.changeClassify(1)}}},[t._v("首页轮播")]),i("p",{on:{click:function(e){return e.stopPropagation(),t.changeClassify(2)}}},[t._v("产品轮播")])]):i("div",{staticClass:"other",class:{changeHeight:t.isPull}},[i("router-link",{attrs:{to:{path:"/banner",query:{id:1}}}},[t._v("首页轮播")]),i("router-link",{attrs:{to:{path:"/banner",query:{id:2}}}},[t._v("产品轮播")])],1)])],2)])},a=[],s={name:"Left",data:function(){return{leftArr:[{name:"产品管理",img:"#icon-chanpin1",num:"0",url:"/product"},{name:"新闻管理",img:"#icon-xinwen",num:"1",url:"/news"},{name:"专利管理",img:"#icon-zhuanli",num:"2",url:"/patent"},{name:"荣誉管理",img:"#icon-rongyu",num:"3",url:"/honor"},{name:"活动管理",img:"#icon-huodong",num:"4",url:"/activity"}]}},props:["curid","isPull","visible"],methods:{pull:function(){this.$emit("pull")},changeClassify:function(t){this.$emit("change",t)}}},r=s,o=i("2877"),l=Object(o["a"])(r,n,a,!1,null,null,null);e["a"]=l.exports},b592:function(t,e,i){"use strict";var n=function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("div",{staticClass:"header"},[i("p",[t._v("人信官网管理系统")]),i("div",{staticClass:"header-right"},[i("ul",[i("li",{on:{click:t.reset}},[i("i",{staticClass:"el-icon-refresh"}),i("span",[t._v("刷新")])]),i("li",{on:{click:t.toLogin}},[i("i",{staticClass:"el-icon-refresh-left"}),i("span",[t._v("注销")])])])])])},a=[],s={name:"HeaderContent",data:function(){return{}},props:[],methods:{reset:function(){this.$router.go(0)},toLogin:function(){sessionStorage.removeItem("cookie"),this.setCookie("mycookid"," ",-1),this.$router.push("/")},setCookie:function(t,e,i){if(0!==i){var n=24*i*60*60*1e3,a=new Date(+new Date+n);document.cookie=t+"="+e+";expires="+a.toUTCString()+"; domain=192.168.10.75; path=/"}else document.cookie=t+"="+e}}},r=s,o=i("2877"),l=Object(o["a"])(r,n,a,!1,null,null,null);e["a"]=l.exports},e8b5:function(t,e,i){var n=i("c6b6");t.exports=Array.isArray||function(t){return"Array"==n(t)}},ff67:function(t,e,i){"use strict";i("1e71")}}]);
//# sourceMappingURL=activityAdd.d983f855.js.map