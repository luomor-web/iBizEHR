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
        name: 'n_ormdutyname_like',
        prop: 'ormdutyname',
        dataType: 'TEXT',
      },
      {
        name: 'n_fglx_like',
        prop: 'fglx',
        dataType: 'TEXT',
      },
      {
        name: 'n_zwlb_like',
        prop: 'zwlb',
        dataType: 'SMCODELIST',
      },
    ]
  }

}