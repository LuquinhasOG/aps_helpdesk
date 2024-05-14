function BarraLateral({children, referencia}) {
    return (
        <aside ref={referencia} className="d-flex flex-column">
            {children}
        </aside>
    );
}

export default BarraLateral;