/**
 * Default 部件模型
 *
 * @export
 * @class DefaultModel
 */
export default class DefaultModel {

  /**
    * 获取数据项集合
    *
    * @returns {any[]}
    * @memberof DefaultModel
    */
  public getDataItems(): any[] {
    return [
      {
        name: 'parexamcycle',
        prop: 'parexamcycleid',
      },
      {
        name: 'createman',
      },
      {
        name: 'parexamcyclename',
      },
      {
        name: 'createdate',
      },
      {
        name: 'updateman',
      },
      {
        name: 'updatedate',
      },
      {
        name: 'cycleid',
      },
    ]
  }


}