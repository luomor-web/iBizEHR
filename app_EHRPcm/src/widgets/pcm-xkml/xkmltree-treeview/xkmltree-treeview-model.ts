/**
 * XKMLtree 部件模型
 *
 * @export
 * @class XKMLtreeModel
 */
export default class XKMLtreeModel {

  /**
    * 获取数据项集合
    *
    * @returns {any[]}
    * @memberof XKMLtreeModel
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