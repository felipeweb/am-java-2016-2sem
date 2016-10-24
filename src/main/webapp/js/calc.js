var form = $('#invest_form');
form.on('submit', function (e) {
    e.preventDefault();
    var checkboxes = $('.ck_pkg');
    console.log(checkboxes.length);
    checkboxes.each(function () {
        var id = $(this).data('input-id');
        var input = $('#' + id);
        var qtd = $('#select_' + id).val();
        var compras = input.val();
        var val = parseInt(qtd) + parseInt(compras);
        input.val(val);
    });
    console.log('passei por aqui');
    form.unbind('submit');
    form.submit();
});