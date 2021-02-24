
// 介绍
let num = parseInt(location.search.slice(4))


// 智慧校园中的智慧教室、智慧图书馆建设，在当前的数字化环境下还面临不少问题，尤其是数据孤岛、智慧化程度不高等问题，
// 根据十四五规划，下一步建设最重要的是打通物理空间、信息空间和认知空间，形成学为中心、精准引导、因材施教、合作育人的全新教育形态。

// 阅读是学习的基础，也是智慧校园建设的根基，阅读难、看不懂、理解差等阅读困难综合症是当前最痛苦的问题，AI人工智能阅读时打通物理空间、信息空间和认知空间
// 的融合，形成智慧化的辅导输出，为读者解决了一个千百年来难以解决的解读难题，最终实现人工智能的智慧阅读，解决校园阅读的智慧化。
let imgArr = ["../img/product_bg.jpg", "../img/dress_bg.jpg", "../img/database_bg.jpg"]
$(".group-bg img").attr("src", imgArr[num - 1])

axios.get(reqURL + "Content1/IndexWisdomRead1/findByclassifyId/" + num).then(data => {
    let str = `              
        <div class="introduce-bg">
            <img src="../img/icon${num+1}.png" alt="">
        </div>
        <div class="introduce-1">
            <img src="${ data.data.result[0].img}" alt="">
            <p> ${ data.data.result[0].content}</p>
        </div>
        <div class="introduce-2">${ data.data.result[0].introduce}</div>`
    $(".introduce").html(str)
})
// 列表
let str1 = ``
axios.get(reqURL + "Content2/IndexWisdomRead2/findAllPage/1/" + num).then(data => {
    data.data.result.list.forEach(val => {
        str1 += `
                <li>
                    <a href="../html/product.html?classify=1&id=${val.details_id}"><img src="${reqURL}${val.img}" alt=""></a>
                    <div class="products">
                        <div class="product-title">${ val.name}</div>
                        <div class="product-info">${ val.centent}</div>
                        <a class="product-btn" href="../html/product.html?classify=${num}&id=${val.details_id}">查看详情</a>
                    </div>
                </li>`
    });
    $(".product-list").html(str1)
})