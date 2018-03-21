const React = require('react');
const ReactDOM = require('react-dom');
const client = require('./client');

class App extends React.Component {

	constructor(props) {
		super(props);
		this.state = {pessoas: []};
	}

	componentDidMount() {
		client({method: 'GET', path: '/api/pessoas'}).done(response => {
			this.setState({pessoas: response.entity._embedded.pessoas});
		});
	}

	render() {
		return (			
			<EmployeeList pessoas={this.state.pessoas}/>
		)
	}
}

class EmployeeList extends React.Component{
	render() {
		var pessoas = this.props.pessoas.map(pessoa =>
			<Employee key={pessoa._links.self.href} pessoa={pessoa}/>
		);
		return (
			<div className="container">
				<table className="table table-striped">
					<thead>
						<tr>
							<th>Nome</th>
							<th>Sobrenome</th>
						</tr>
					</thead>
					<tbody>{pessoas}</tbody>
				</table>
			</div>
		)
	}
}

class Employee extends React.Component{
	render() {
		return (
			<tr>
				<td>{this.props.pessoa.nome}</td>
				<td>{this.props.pessoa.sobreNome}</td>
			</tr>
		)
	}
}

ReactDOM.render(
	<App />,
	document.getElementById('react')
)