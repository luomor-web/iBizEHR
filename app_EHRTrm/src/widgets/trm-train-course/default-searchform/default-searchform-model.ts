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
        name: 'n_trmtraincoursename_like',
        prop: 'trmtraincoursename',
        dataType: 'TEXT',
      },
      {
        name: 'n_kclb_eq',
        prop: 'kclb',
        dataType: 'SSCODELIST',
      },
      {
        name: 'n_skfs_eq',
        prop: 'skfs',
        dataType: 'SSCODELIST',
      },
      {
        name: 'n_trmtrainagencyname_eq',
        prop: 'trmtrainagencyname',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'n_ormorgname_eq',
        prop: 'ormorgname',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'n_ormorgid_eq',
      },
      {
        name: 'n_trmtrainagencyid_eq',
      },
    ]
  }

}