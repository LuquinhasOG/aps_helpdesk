const formatadorDataHora = Intl.DateTimeFormat("pt-BR", {
    year: "numeric",
    month: "numeric",
    day: "numeric",
    hour: "2-digit",
    minute: "2-digit",
    second: "2-digit"
});

export { formatadorDataHora };