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
        name: 'n_pimfaminfoname_like',
        prop: 'pimfaminfoname',
        dataType: 'TEXT',
      },
      {
        name: 'n_xb_eq',
        prop: 'xb',
        dataType: 'SSCODELIST',
      },
      {
        name: 'n_zzmm_eq',
        prop: 'zzmm',
        dataType: 'SSCODELIST',
      },
      {
        name: 'n_sfjjllr_eq',
        prop: 'sfjjllr',
        dataType: 'SSCODELIST',
      },
    ]
  }

}