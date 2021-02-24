

// 新闻列表
$.get(reqURL + "Journalism/findAllPage/1", function (data, status) {
    if (status == "success") {
        let str = ''
        data.result.list.forEach(val => {
            str += '<li><a href="html/newInfo.html?id=' + val.details_id + '"><span></span><p>' + val.name + '</p></a></li>'
        });
        $(".line-list").html(str)
        let str2 = `<a href=" html/newInfo.html?id=${data.result.list[0].details_id}">
                <img src="${reqURL}${data.result.list[0].img}" alt="">
                        <p class="line-title">${ data.result.list[0].name}</p></a>`
        $(".line-left").html(str2)
    }
})

// 数据库定制
axios.get(reqURL + "Content2/IndexWisdomRead2/findAllPage/1/3").then(data => {
    let str3 = ``
    let arr = data.data.result.list.slice(0, 8)
    arr.forEach(val => {
        str3 += `<li><a href="html/product.html?classify=3&id=${val.id}">${val.name}</a></li>`
    });
    $(".develop-left ol").html(str3)
})

// 轮播图
axios.get(reqURL + "index/indexAboutus").then(data => {
    let str = ``
    console.log(data)
    data.data.result.forEach(val => {
        // 获取轮播图
        switch (val.classify) {
            case "新闻":
                str += `  
                <div class="swiper-slide"><a href="html/newInfo.html?id=${val.details_id}">
                <img src="${reqURL}${val.img}" alt="" class="a1"></a></div>
                `
                break;
            case "活动":
                str += `  
                <div class="swiper-slide"><a href="html/courseInfo.html?id=${val.details_id}">
                <img src="${reqURL}${val.img}" alt="" class="a1"></a></div>
                `
                break;
            case "专利":
                str += `  
                <div class="swiper-slide"><a href="html/honor.html?findPatentsAll">
                <img src="${reqURL}${val.img}" alt="" class="a1"></a></div>
                `
                break;
            case "荣誉":
                str += `  
                <div class="swiper-slide"><a href="html/honor.html?findHonorsAll">
                <img src="${reqURL}${val.img}" alt="" class="a1"></a></div>
                `
            case "智慧阅读":
                str += `  
                    <div class="swiper-slide"><a href="html/product.html?classify=1&id=${ val.details_id}">
                    <img src="${reqURL}${val.img}" alt="" class="a1"></a></div>
                    `
                break;
            case "智能穿戴":
                str += `  
                    <div class="swiper-slide"><a href="html/product.html?classify=2&id=${ val.details_id}">
                    <img src="${reqURL}${val.img}" alt="" class="a1"></a></div>
                    `
                break;
            case "数据库":
                str += `  
                    <div class="swiper-slide"><a href="html/product.html?classify=3&id=${ val.details_id}">
                    <img src="${reqURL}${val.img}" alt="" class="a1"></a></div>
                    `
                break;
        }
    });
    $(".banner-list").html(str)
    // 轮播图
    let swiper = new Swiper('.swiper-container', {
        loop: true,
        autoplay: {
            delay: 5000,
            disableOnInteraction: false,
        },
        pagination: {
            el: '.pagination',
            clickable: true,
            type: 'custom',
            renderCustom: function (swiper, current, total) {
                var paginationHtml = "";
                for (var i = 0; i < total; i++) {
                    // 判断是不是激活焦点，是的话添加active类，不是就只添加基本样式类
                    if (i === (current - 1)) {
                        paginationHtml += '<li class="swiper-pagination-customs swiper-pagination-customs-activ"></li>';
                    }
                    else {
                        paginationHtml += '<li class="swiper-pagination-customs"></li>';
                    }
                }
                return paginationHtml;
            }
        }
    });
    // 分页点击
    $('.pagination').on('click', "li", function () {
        let num = $(this).index() + 1
        swiper.slideTo(num, 500, false);
    })
})

// 调用产品轮播
axios.get(reqURL + "GoodsCarousel/findGoodsCarouselAll").then(data => {
    let str = ``
    let readArr = []
    let dress = ``
    let dressArr = []
    data.data.result.forEach(val => {
        // 智慧阅读
        if (val.classify == 1) {
            readArr.push(val)
            str += `<div class="swiper-slide"><a href="html/product.html?classify=1&id=${val.details_id}">
                    <img src="${reqURL}${val.img}" alt=""></a></div>`
        }
        // 智能穿戴
        else if (val.classify == 2) {
            dressArr.push(val)
            dress += `<div class="swiper-slide"><a href="html/product.html?classify=2&id=${val.details_id}">
                    <img src="${reqURL}${val.img}" alt=""></a></div>`
        }
    })
    $(".read-box").html(str)
    $(".dress-box").html(dress)
    productMove('.swiper2', '.read-name', 6000, readArr)
    productMove('.swiper3', '.dress-name', 8000, dressArr)
})

// 产品轮播图
function productMove(obj, btn, speed, arr) {
    // obj动画的节点，btn分页按钮，speed动画速度,arr图片集合
    let DressSwiper = new Swiper(obj, {
        loop: true,
        autoplay: {
            delay: speed,
            disableOnInteraction: false,
        },
        pagination: {
            el: btn,
            clickable: true,
            type: 'custom',
            renderCustom: function (swiper, current, total) {
                let paginationHtml = "";
                for (var i = 0; i < total; i++) {
                    // 判断是不是激活焦点，是的话添加active类，不是就只添加基本样式类
                    if (i === (current - 1)) {
                        paginationHtml += `<span class="read-btn read-btn-active">${arr[i].name}</span>`;
                    }
                    else {
                        paginationHtml += `<span class="read-btn">${arr[i].name}</span>`;
                    }
                }
                return paginationHtml;
            }
        }
    });
    // 分页点击
    $(btn).on('click', "span", function () {
        let num = $(this).index() + 1
        DressSwiper.slideTo(num, 1000, false);
    })
}

// 节点到浏览器顶部的距离
function getElementToPageTop(el) {
    if (el.parentElement) {
        return this.getElementToPageTop(el.parentElement) + el.offsetTop
    }
    return el.offsetTop
}
// 到达指定位置
$(".advert ol li").click(function () {
    let num = parseInt($(this).index())
    if (num == $(".about-content")[0].children.length) {
        document.documentElement.scrollTop = 0
        return
    }
    document.documentElement.scrollTop = arr[num]
})

// 悬浮按钮
let arr = []
for (let i = 0; i < $(".about-content")[0].children.length; i++) {
    arr.push(getElementToPageTop($(".about-content")[0].children[i]))
}

// 定义窗口高度
var viewHeigth = 0
document.onscroll = function () {
    viewHeigth = window.innerHeight - 300
    if (window.pageYOffset >= viewHeigth) {
        $(".advert-btn")[0].style.display = "block"
    }
    else {
        $(".advert-btn")[0].style.display = "none"
    }
}
window.onresize = function () {
    viewHeigth = window.innerHeight
}









