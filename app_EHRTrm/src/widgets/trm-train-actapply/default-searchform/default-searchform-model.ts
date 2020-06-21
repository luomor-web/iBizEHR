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
        name: 'n_ormorgsectorname_eq',
        prop: 'ormorgsectorname',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'n_pxdxlb_eq',
        prop: 'pxdxlb',
        dataType: 'SSCODELIST',
      },
      {
        name: 'n_pxfs_eq',
        prop: 'pxfs',
        dataType: 'SSCODELIST',
      },
      {
        name: 'n_pxjb_eq',
        prop: 'pxjb',
        dataType: 'SSCODELIST',
      },
      {
        name: 'n_pxlb_eq',
        prop: 'pxlb',
        dataType: 'SSCODELIST',
      },
      {
        name: 'n_pxnd_eq',
        prop: 'pxnd',
        dataType: 'SSCODELIST',
      },
      {
        name: 'n_pxjd_eq',
        prop: 'pxjd',
        dataType: 'SSCODELIST',
      },
      {
        name: 'n_pxyf_eq',
        prop: 'pxyf',
        dataType: 'SSCODELIST',
      },
      {
        name: 'n_ormorgsectorid_eq',
      },
    ]
  }

}