from exception_handler import *
from notebook import *
from flask import Flask, request, jsonify, make_response

app = Flask(__name__)
handler = ExceptionHandler(app)


@app.route('/api/notebook/display', methods=['GET', ])
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


