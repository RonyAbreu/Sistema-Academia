const btnCadastrar = document.getElementById('custom-btn')
const inputNome = document.getElementById('nome')
const inputIdade = document.getElementById('idade')
const inputPeso = document.getElementById('peso')
const inputAltura = document.getElementById('altura')
const inputRua = document.getElementById('rua')
const inputBairro = document.getElementById('bairro')
const inputNumCasa = document.getElementById('numcasa')

const inputSimDiabetes = document.getElementById('btn-sim-diabetes')
const inputSimPressaoAlta = document.getElementById('btn-sim-pressao')

const form = document.querySelector('form')

const baseURL = 'http://localhost:8080'

form.addEventListener('submit', (e) =>{
    e.preventDefault()

    cadastrarCliente()
})

function cadastrarCliente(){
    const cliente = criarCliente()

    axios.post(baseURL+'/pessoa',{
        nome: cliente.nome,
        idade: cliente.idade,
        peso: cliente.peso,
        altura: cliente.altura,
        temDiabetes: cliente.temDiabetes,
        temPressaoAlta: cliente.temPressaoAlta
    })
    .then((result) => {
        let id = result.data.id
        cadastraEndereco(id)
        alert('Cliente cadastrado com sucesso!')
        form.reset()
        limpaBotoes()
    })
    .catch((err) => {
        console.log(err)
        alert('Erro ao efetuar cadastro!')
    })
}

inputSimDiabetes.addEventListener('click', ()=>{
    inputSimDiabetes.setAttribute('checked', 'checked')
})

inputSimPressaoAlta.addEventListener('click', ()=>{
    inputSimPressaoAlta.setAttribute('checked', 'checked')
})

function limpaBotoes(){
    inputSimDiabetes.removeAttribute('checked')
    inputSimPressaoAlta.removeAttribute('checked')
}

function criarCliente(){
    let nome = inputNome.value 
    let idade = inputIdade.value
    let peso = inputPeso.value
    let altura = inputAltura.value
    let temDiabetes = ehDiabetico()
    let temPressaoAlta = ehPressaoAlta()

    const cliente = {
        nome: nome,
        idade: idade,
        peso: peso,
        altura: altura,
        temDiabetes: temDiabetes,
        temPressaoAlta: temPressaoAlta
    }

    return cliente
}

function ehDiabetico(){
    if(inputSimDiabetes.getAttribute('checked') == null){
        console.log('caiu no diabetes')
        return false
    }
    return true
}

function ehPressaoAlta(){
    if(inputSimPressaoAlta.getAttribute('checked') == null){
        console.log('caiu no pressao')
        return false
    }
    return true
}

function cadastraEndereco(idPessoa){
    const endereco = criarEndereco()

    axios.post(`${baseURL}/endereco/${idPessoa}`,{
        rua: endereco.rua,
        bairro: endereco.bairro,
        numeroDaCasa: endereco.numCasa
    })
    .catch((err) => {
        console.log(err)
    })
}

function criarEndereco(){
    let rua = inputRua.value
    let bairro = inputBairro.value
    let numCasa = inputNumCasa.value

    const endereco = {
        rua: rua,
        bairro: bairro,
        numCasa: numCasa
    }

    return endereco
}
