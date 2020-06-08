/**
 * XKMLTreeExpViewtreeexpbar 部件模型
 *
 * @export
 * @class XKMLTreeExpViewtreeexpbarModel
 */
export default class XKMLTreeExpViewtreeexpbarModel {

  /**
    * 获取数据项集合
    *
    * @returns {any[]}
    * @memberof XKMLTreeExpViewtreeexpbarModel
    */
  public getDataItems(): any[] {
    return [
      {
        name: 'nd',
      },
      {
        name: 'createdate',
      },
      {
        name: 'pcmxkmlname',
      },
      {
        name: 'updateman',
      },
      {
        name: 'pcmxkml',
        prop: 'pcmxkmlid',
      },
      {
        name: 'xh',
      },
      {
        name: 'updatedate',
      },
      {
        name: 'createman',
      },
      {
        name: 'xkml',
      },
    ]
  }


}