import { useEffect, useState } from "react";
import CardChamado from "./CardChamado";

function ContainerCardChamados({id_usuario, id_estado_ticket, nivel_permissao}) {
    const [chamados, setChamados] = useState([]);

    console.log(chamados.length)

    useEffect(() => {
        // se o nível for 1 (nível do usuário comum), ele vai poder ver só os chamados que ele abrir
        // mas se for maior que 1, vai ver todos os chamados
        if (nivel_permissao > 1) {
            fetch(`http://localhost:8080/tickets`)
            .then(retorno => retorno.json())
            .then(retorno => {
                setChamados(retorno);
            })
        } else {
            fetch(`http://localhost:8080/tickets/usuario/${id_usuario}`)
            .then(retorno => retorno.json())
            .then(retorno => {
                setChamados(retorno);
            })
        }
    }, []);

    return (
        <div className="d-flex justify-content-around flex-row flex-wrap">
            {
                chamados.map((el, i) => {
                    if (id_estado_ticket == 0) {
                        return <CardChamado key={i} conteudo={el} />
                    } else if (id_estado_ticket == 1 && el.estadoTicket.idEstadoTicket == id_estado_ticket) {
                        return <CardChamado key={i} conteudo={el} />
                    } else if (id_estado_ticket > 1 && el.estadoTicket.idEstadoTicket > 1) {
                        return <CardChamado key={i} conteudo={el} />
                    }
                })
            }
        </div>
    );
}

export default ContainerCardChamados;