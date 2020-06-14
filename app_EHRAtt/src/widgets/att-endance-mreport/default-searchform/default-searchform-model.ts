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
        name: 'n_nd_eq',
        prop: 'nd',
        dataType: 'SSCODELIST',
      },
      {
        name: 'n_yf_eq',
        prop: 'yf',
        dataType: 'SSCODELIST',
      },
      {
        name: 'n_zt_eq',
        prop: 'zt',
        dataType: 'SSCODELIST',
      },
    ]
  }

}