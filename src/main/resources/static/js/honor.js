

let string = location.search.slice(1)
if (string == "findPatentsAll") {
    $(".introduce").html(`<h2> 集团专利 <span>Group Patent</span></h2>`)
    $(".group-bg img").attr("src", "../img/patent_bg.jpg")
    $(".introduce-bg img").attr("src", "../img/icon6.png")
}

// 获取列表
axios.get(reqURL + "HonorsAndPatents/" + string).then(data => {
    let str = ``
    if ( string == "findPatentsAll") {
        data.data.result.forEach(val => {
            str += `               
                <li class="patent-li">
                    <img src="${reqURL}${val.img}" alt="">
                    <h3>${val.name}</h3>
                </li>`
        });
    }
    else {
        data.data.result.forEach(val => {
            str += `               
                <li class="honor-li">
                    <img src="${reqURL}${val.img}" alt="">
                    <h3>${val.name}</h3>
                </li>`
        });
    }
    $(".honor-list").html(str)
})