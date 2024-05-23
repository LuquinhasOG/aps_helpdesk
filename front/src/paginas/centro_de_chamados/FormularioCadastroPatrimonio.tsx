import { useState } from "react";

const modeloInformacoesPatrimonio = {
    nomePatrimonio: "",
    descricao: "",
    preco: "0",
    quantidade: "0",
    dataCriacao: new Date()
}

function FormularioCadastroPatrimonio() {
    const [infoPatrimonioCadastrar, setInfoPatrimonioCadastrar] = useState(modeloInformacoesPatrimonio);

    console.log(infoPatrimonioCadastrar);

    const eventoAtualizarAoDigitar = (evento) => {
        setInfoPatrimonioCadastrar({...infoPatrimonioCadastrar, [evento.target.name]:evento.target.value})
    }

    const eventoCadastrarPatrimonio = () => {
        const temp = {...infoPatrimonioCadastrar};
        temp.dataCriacao = new Date();

        fetch("http://localhost:8080/patrimonio", {
            method: "post",
            body: JSON.stringify(infoPatrimonioCadastrar),
            headers: {
                'Content-type': 'application/json',
                'Accept': 'application/json'
            }
        })
        .then(retorno => retorno.json())
        .then(retorno => console.log(retorno))
    }

    return (
        <div>
            <h3 className="text-center">Cadastro Patrimônio</h3>
            <form className="d-flex flex-column">
                <div className="d-flex flex-column">
                    <label>Nome</label>
                    <input type="text" onChange={eventoAtualizarAoDigitar} name="nomePatrimonio" />
                </div>
                <div className="d-flex flex-column">
                    <label>Descrição</label>
                    <input type="text" onChange={eventoAtualizarAoDigitar} name="descricao" />
                </div>
                <div className="row">
                    <div className="d-flex flex-column col">
                        <label>Preco</label>
                        <input type="number" min={0} onChange={eventoAtualizarAoDigitar} name="preco" />
                    </div>
                    <div className="d-flex flex-column col">
                        <label>Quantidade</label>
                        <input type="number" min={1} onChange={eventoAtualizarAoDigitar} name="quantidade" />
                    </div>
                </div>

                <div className="d-flex">
                    <div className="col"></div>
                    <input type="button" value="Enviar" className="btn btn-success col mt-4" onClick={eventoCadastrarPatrimonio} />
                    <div className="col"></div>
                </div>
            </form>
        </div>
    );
}

export default FormularioCadastroPatrimonio;