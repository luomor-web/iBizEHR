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
        name: 'n_ormpostname_like',
        prop: 'ormpostname',
        dataType: 'TEXT',
      },
      {
        name: 'n_ormorgname_like',
        prop: 'ormorgname',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'n_startstopsign_eq',
        prop: 'startstopsign',
        dataType: 'SSCODELIST',
      },
      {
        name: 'n_gwtype_eq',
        prop: 'gwtype',
        dataType: 'SMCODELIST',
      },
    ]
  }

}