
// 活动历程
axios.get(reqURL + "HonorsAndPatents/findactivityAll").then(data => {
    let str = ``
    data.data.result.forEach(val => {
        str += `
            <li>
                <a href="courseInfo.html?id=${val.details_id}">
                    <img src="${reqURL}${val.img}" alt="">
                </a>
                <h3>${val.name}</h3>
            </li>`
    });
    $(".honor-list").html(str)
})

