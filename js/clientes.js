axios.get('http://localhost:8080/pessoa')
        .then(function (response) {
            preencherTabela(response.data)
        })
        .catch(function (error) {
            console.error('Erro na requisição:', error);
        });

// Função para preencher a tabela com os dados recebidos
function preencherTabela(dados) {
    let tabela = document.getElementById('dados-tabela');

    const aviso = document.getElementById('aviso')
    if(dados.length == 0){
        aviso.style.display = 'block'
    } else {
        aviso.style.display = 'none'

        dados.forEach(function (pessoa) {
            let row = tabela.insertRow();
    
            // Preenche cada célula da linha
            row.insertCell(0).innerHTML = pessoa.nome;
            row.insertCell(1).innerHTML = pessoa.idade;
            row.insertCell(2).innerHTML = pessoa.peso;
            row.insertCell(3).innerHTML = pessoa.altura;
            row.insertCell(4).innerHTML = pessoa.endereco.rua;
            row.insertCell(5).innerHTML = pessoa.endereco.bairro;
            row.insertCell(6).innerHTML = pessoa.endereco.numeroDaCasa;
        });
    }
}