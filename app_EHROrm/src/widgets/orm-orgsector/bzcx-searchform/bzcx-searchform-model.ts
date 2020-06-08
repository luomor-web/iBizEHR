/**
 * BZCX 部件模型
 *
 * @export
 * @class BZCXModel
 */
export default class BZCXModel {

  /**
  * 获取数据项集合
  *
  * @returns {any[]}
  * @memberof BZCXModel
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
        name: 'n_orgname_like',
        prop: 'orgname',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'n_orgsectorname_like',
        prop: 'orgsectorname',
        dataType: 'TEXT',
      },
    ]
  }

}