import nbformat
from nbconvert import HTMLExporter


def read_file(file_path):
    with open(file_path, 'r', encoding='utf-8') as f:
        content = f.read()
        return content


def parse_notebook(content):
    parsed = nbformat.reads(content, as_version=4)
    return parsed


def render_html(content):
    parsed = parse_notebook(content)

    html_exporter = HTMLExporter()
    html_exporter.template_file = 'basic'

    (body, resources) = html_exporter.from_notebook_node(parsed)

    return body
