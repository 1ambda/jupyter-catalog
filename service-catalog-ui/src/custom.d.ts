// https://github.com/ElemeFE/element/issues/9084
declare module 'element-ui/lib/locale/lang/en' {
}

// https://github.com/ElemeFE/element/issues/15918
type PluginFunction<T> = (Vue: any, options?: T) => void;
interface PluginObject<T> {
  install: PluginFunction<T>;
  [key: string]: any;
}

