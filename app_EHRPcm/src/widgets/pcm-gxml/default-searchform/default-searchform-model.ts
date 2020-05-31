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
        name: 'srfwfmemo',
        prop: 'srfwfmemo',
        dataType: 'TEXT',
      },
      // 前端新增修改标识，新增为"0",修改为"1"或未设值
      {
        name: 'srffrontuf',
        prop: 'srffrontuf',
        dataType: 'TEXT',
      },
      {
        name: 'n_nationarea_like',
        prop: 'nationarea',
        dataType: 'TEXT',
      },
      {
        name: 'n_xxxz_eq',
        prop: 'xxxz',
        dataType: 'SSCODELIST',
      },
      {
        name: 'n_pcmgxmlname_like',
        prop: 'pcmgxmlname',
        dataType: 'TEXT',
      },
    ]
  }

}