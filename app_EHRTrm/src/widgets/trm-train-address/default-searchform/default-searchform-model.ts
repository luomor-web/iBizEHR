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
        name: 'n_trmtrainaddressname_like',
        prop: 'trmtrainaddressname',
        dataType: 'TEXT',
      },
      {
        name: 'n_s_eq',
        prop: 's',
        dataType: 'TEXT',
      },
      {
        name: 'n_sf_eq',
        prop: 'sf',
        dataType: 'SSCODELIST',
      },
      {
        name: 'n_hjzk_eq',
        prop: 'hjzk',
        dataType: 'SSCODELIST',
      },
      {
        name: 'n_pxlx_eq',
        prop: 'pxlx',
        dataType: 'SSCODELIST',
      },
    ]
  }

}