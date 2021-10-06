window.onload = function () {
    $('.all-flags .flag-icon-background').click(function(event){
        // let flag = $(event.currentTarget).attr('title');
        let flag = 'ua';
        let w = 640;
        let h = 480;
        let left = (screen.width / 2) - (w / 2);
        let top = (screen.height / 2) - (h / 2);

        if (flag) {
            window.open('../../resources/img/flags' + flag + '.svg', 'flag-4x3', 'width=' + w + ', height=' + h + ', top=' + top + ', left=' + left);
        }
    });
}