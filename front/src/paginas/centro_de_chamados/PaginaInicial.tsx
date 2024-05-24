import { useEffect, useRef, useState } from "react";
import { useNavigate } from "react-router-dom";
import BarraLateral from "./BarraLateral";
import BotaoBarraLateral from "./BotaoBarraLateral";
import FormularioAberturaTicket from "./FormularioAberturaTicket";
import ContainerCardChamados from "./ContainerCardChamados";
import UsuarioServico from "../../servicos/UsuarioServico";
import FormularioCadastroPatrimonio from "./FormularioCadastroPatrimonio";

const usuario = new UsuarioServico();

const idUsuario = usuario.idUsuario;
const nivelPermissao = usuario.nivelPermissao;

function PaginaInicial() {
    const barraLateralRef = useRef(null);
    const [botaoAtivo, setBotaoAtivo] = useState(0);
    const mudarPagina = useNavigate();

    useEffect(() => {
        if (localStorage.getItem("id_ticket_aberto") != undefined) {
            mudarPagina(`../chamado/${localStorage.getItem("id_ticket_aberto")}`);
            localStorage.removeItem("id_ticket_aberto");
        }
    }, []);

    const eventoClicarBotaoChamado = () => {
        setBotaoAtivo(0);
    }

    const eventoClicarBotaoChamadosAbertos = () => {
        setBotaoAtivo(1);
    }

    const eventoClicarBotaoChamadosFechados = () => {
        setBotaoAtivo(2);
    }

    const eventoClicarBotaoAbrirChamado = () => {
        setBotaoAtivo(3);
    }

    const eventoClicarBotaoCadastrarPatrimonio = () => {
        setBotaoAtivo(4);
    }

    const verificaBotaoAtivo = () => {
        if (botaoAtivo >= 0 && botaoAtivo <= 2) {
            return <ContainerCardChamados id_usuario={idUsuario} id_estado_ticket={botaoAtivo} nivel_permissao={nivelPermissao} />;
        } else if (botaoAtivo == 3) {
            return <FormularioAberturaTicket />;
        } else if (botaoAtivo == 4) {
            return <FormularioCadastroPatrimonio />;
        }
    }

    return (
        <div>
            <h2 className="text-center mb-4">Centro de Chamados</h2>
            <div className="container">
                <div className="row">
                    <div className="col-3">
                        <BarraLateral referencia={barraLateralRef}>
                            <BotaoBarraLateral id_botao={0} texto="Todos Chamados" ativo={botaoAtivo} evento_clique={eventoClicarBotaoChamado} />
                            <BotaoBarraLateral id_botao={1} texto="Chamados Abertos" ativo={botaoAtivo} evento_clique={eventoClicarBotaoChamadosAbertos} />
                            <BotaoBarraLateral id_botao={2} texto="Chamados Finalizados" ativo={botaoAtivo} evento_clique={eventoClicarBotaoChamadosFechados} />
                            <BotaoBarraLateral id_botao={3} texto="Abrir Chamado" ativo={botaoAtivo} evento_clique={eventoClicarBotaoAbrirChamado} />
                            <BotaoBarraLateral id_botao={4} texto="Cadastrar Patrimônio" ativo={botaoAtivo} evento_clique={eventoClicarBotaoCadastrarPatrimonio} />
                        </BarraLateral>
                    </div>
                    <div className="col">
                        {verificaBotaoAtivo()}
                    </div>
                </div>
            </div>
        </div>
    );
}

export default PaginaInicial;