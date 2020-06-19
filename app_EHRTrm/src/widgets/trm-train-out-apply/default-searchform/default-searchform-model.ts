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
        name: 'n_trmtrainoutapplyname_like',
        prop: 'trmtrainoutapplyname',
        dataType: 'TEXT',
      },
      {
        name: 'n_pxfs_eq',
        prop: 'pxfs',
        dataType: 'TEXT',
      },
      {
        name: 'n_pxlb_eq',
        prop: 'pxlb',
        dataType: 'TEXT',
      },
      {
        name: 'n_ywlx_eq',
        prop: 'ywlx',
        dataType: 'TEXT',
      },
      {
        name: 'n_wbpxjg_eq',
        prop: 'wbpxjg',
        dataType: 'TEXT',
      },
      {
        name: 'n_pimpersonname_like',
        prop: 'pimpersonname',
        dataType: 'PICKUPTEXT',
      },
    ]
  }

}