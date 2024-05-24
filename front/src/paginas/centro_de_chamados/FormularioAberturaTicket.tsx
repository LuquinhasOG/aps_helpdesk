import { useEffect, useState } from "react";

const modeloInformacoesTicket = {
    titulo: "",
    descricao: "",
    usuarioAbertura: parseInt(localStorage.getItem("id_usuario")),
    estadoTicket: 1,
    dataAbertura: new Date(),
    idPatrimonio: ""
}

function FormularioAberturaTicket() {
    const [informacoesTicket, setInformacoesTicket] = useState(modeloInformacoesTicket);
    const [patrimonios, setPatrimonios] = useState([])
    // const [patrimonioSelecionado, setPatrimonioSelecionado] = useState("");

    const eventoAtualizarAoDigitar = (evento) => {
        setInformacoesTicket({...informacoesTicket, [evento.target.name]:evento.target.value});
    }

    const eventoCadastrarTicket = () => {
        fetch("http://localhost:8080/tickets", {
            method: "post",
            body: JSON.stringify(informacoesTicket),
            headers: {
                'Content-type': 'application/json',
                'Accept': 'application/json'
            }
        })
        .then(retorno_para_json => retorno_para_json.json())
        .then(retorno => {
            localStorage.setItem("id_ticket_aberto", retorno.idTicket);
            location.reload();
        })
    }

    const atualizarPatrimonioSelecionado = (evento) => {
        setInformacoesTicket({...informacoesTicket, idPatrimonio: evento.target.value})
    }

    useEffect(() => {
        fetch(`http://localhost:8080/patrimonio/usuario/${localStorage.getItem("id_usuario")}`)
        .then(retorno => retorno.json())
        .then(retorno => setPatrimonios(retorno));
    }, [])

    return (
        <form className="d-flex flex-column">
            <div className="d-flex flex-column">
                <label>Título do chamado</label>
                <input type="text" name="titulo" onChange={eventoAtualizarAoDigitar} />
            </div>
            <div className="d-flex flex-column">
                <label>Descrição detalhada do problema</label>
                <textarea style={{height: "15rem"}} name="descricao" onChange={eventoAtualizarAoDigitar}></textarea>
            </div>
            <div className="row">
                <div className="d-flex flex-column col">
                    <label>Patrimônio</label>
                    <select onChange={atualizarPatrimonioSelecionado} name="patrimonios">
                        <option value="" selected disabled hidden>Escolha um patrimônio</option>
                        {
                            patrimonios.map((el) => {
                                return <option value={el.idPatrimonio} key={el.idPatrimonio}>{el.nomePatrimonio}</option>
                            })
                        }
                    </select>
                </div>
                <div className="col"></div>
                <input type="button" value="Abrir Chamado" className="col btn btn-success" onClick={eventoCadastrarTicket} />
            </div>
        </form>
    );
}

export default FormularioAberturaTicket;