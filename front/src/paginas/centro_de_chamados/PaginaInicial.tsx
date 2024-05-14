import { useEffect, useRef, useState } from "react";
import BarraLateral from "./BarraLateral";
import BotaoBarraLateral from "./BotaoBarraLateral";
import FormularioAberturaTicket from "./FormularioAberturaTicket";
import { useNavigate } from "react-router-dom";

function PaginaInicial() {
    const [abrindoChamado, setAbrindoChamado] = useState(false);
    const barraLateralRef = useRef(null);
    const [botaoChamado, setBotaoChamado] = useState(true);
    const [botaoChamadoAberto, setBotaoChamadosAbertos] = useState(false);
    const [botaoChamadoFechado, setBotaoChamadosFechados] = useState(false);
    const [botaoAbrirChamado, setBotaoAbrirChamado] = useState(false);

    const mudarPagina = useNavigate();

    useEffect(() => {
        if (localStorage.getItem("id_ticket_aberto") != undefined) {
            mudarPagina(`../chamado/${localStorage.getItem("id_ticket_aberto")}`);
            localStorage.removeItem("id_ticket_aberto");
        }
    }, []);

    const eventoClicarBotaoChamado = () => {
        setBotaoChamado(true);
        setBotaoChamadosAbertos(false);
        setBotaoChamadosFechados(false);
        setBotaoAbrirChamado(false);
    }

    const eventoClicarBotaoChamadosAbertos = () => {
        setBotaoChamado(false);
        setBotaoChamadosAbertos(true);
        setBotaoChamadosFechados(false);
        setBotaoAbrirChamado(false);
    }

    const eventoClicarBotaoChamadosFechados = () => {
        setBotaoChamado(false);
        setBotaoChamadosAbertos(false);
        setBotaoChamadosFechados(true);
        setBotaoAbrirChamado(false);
    }

    const eventoClicarBotaoAbrirChamado = () => {
        setBotaoChamado(false);
        setBotaoChamadosAbertos(false);
        setBotaoChamadosFechados(false);
        setBotaoAbrirChamado(true);
    }

    return (
        <div>
            <h1>Página inicial do centro de chamados</h1>
            <div className="container">
                <div className="row">
                    <div className="col-3">
                        <BarraLateral referencia={barraLateralRef}>
                            <BotaoBarraLateral texto="Todos Chamados" ativo={botaoChamado} evento_clique={eventoClicarBotaoChamado} />
                            <BotaoBarraLateral texto="Chamados Abertos" ativo={botaoChamadoAberto} evento_clique={eventoClicarBotaoChamadosAbertos} />
                            <BotaoBarraLateral texto="Chamados Fechado" ativo={botaoChamadoFechado} evento_clique={eventoClicarBotaoChamadosFechados} />
                            <BotaoBarraLateral texto="Abrir Chamado" ativo={botaoAbrirChamado} evento_clique={eventoClicarBotaoAbrirChamado} />
                        </BarraLateral>
                    </div>
                    <div className="col">
                        { (botaoAbrirChamado) ? <FormularioAberturaTicket /> : null }
                    </div>
                </div>
            </div>
        </div>
    );
}

export default PaginaInicial;