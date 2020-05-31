/**
 * GXMLtree 部件模型
 *
 * @export
 * @class GXMLtreeModel
 */
export default class GXMLtreeModel {

  /**
    * 获取数据项集合
    *
    * @returns {any[]}
    * @memberof GXMLtreeModel
    */
  public getDataItems(): any[] {
    return [
      {
        name: 'nd',
      },
      {
        name: 'pcmgxml',
        prop: 'pcmgxmlid',
      },
      {
        name: 'createman',
      },
      {
        name: 'xh',
      },
      {
        name: 'updatedate',
      },
      {
        name: 'updateman',
      },
      {
        name: 'xxxz',
      },
      {
        name: 'createdate',
      },
      {
        name: 'gxlb',
      },
      {
        name: 'nationarea',
      },
      {
        name: 'pcmgxmlname',
      },
    ]
  }


}