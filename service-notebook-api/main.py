import nbformat
from exception_handler import *
from flask import Flask, request, jsonify, make_response
from nbconvert import HTMLExporter

app = Flask(__name__)
handler = ExceptionHandler(app)


@app.route('/api/notebook/render', methods=['GET', ])
def render_notebook():
    file_path = request.args.get("path")

    try:
        notebook_content = read_file(file_path)
        notebook_rendered = render_html(notebook_content)
    except Exception as e:
        json_error = ExceptionHandler().std_handler(e)
        return make_response(json_error, 500)

    return make_response(jsonify({
        'path': file_path,
        'content': notebook_rendered,
    }), 200)


def read_file(file_path):
    with open(file_path, 'r', encoding='utf-8') as f:
        content = f.read()
        return content


def render_html(content):
    parsed = nbformat.reads(content, as_version=4)

    html_exporter = HTMLExporter()
    html_exporter.template_file = 'basic'

    (body, resources) = html_exporter.from_notebook_node(parsed)

    return body
