/**
 * Main 部件模型
 *
 * @export
 * @class MainModel
 */
export default class MainModel {

  /**
  * 获取数据项集合
  *
  * @returns {any[]}
  * @memberof MainModel
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
        name: 'srfupdatedate',
        prop: 'updatedate',
        dataType: 'DATETIME',
      },
      {
        name: 'srforikey',
      },
      {
        name: 'srfkey',
        prop: 'pimlanguageabilityid',
        dataType: 'GUID',
      },
      {
        name: 'srfmajortext',
        prop: 'pimlanguageabilityname',
        dataType: 'TEXT',
      },
      {
        name: 'srftempmode',
      },
      {
        name: 'srfuf',
      },
      {
        name: 'srfdeid',
      },
      {
        name: 'srfsourcekey',
      },
      {
        name: 'pimpersonname',
        prop: 'pimpersonname',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'wyyz',
        prop: 'wyyz',
        dataType: 'SSCODELIST',
      },
      {
        name: 'wydj',
        prop: 'wydj',
        dataType: 'SSCODELIST',
      },
      {
        name: 'wydjhqsj',
        prop: 'wydjhqsj',
        dataType: 'DATE',
      },
      {
        name: 'bz',
        prop: 'bz',
        dataType: 'TEXT',
      },
      {
        name: 'pimpersonid',
        prop: 'pimpersonid',
        dataType: 'PICKUP',
      },
      {
        name: 'fj',
        prop: 'fj',
        dataType: 'TEXT',
      },
      {
        name: 'jlss',
        prop: 'jlss',
        dataType: 'SSCODELIST',
      },
      {
        name: 'jlczz',
        prop: 'jlczz',
        dataType: 'TEXT',
      },
      {
        name: 'pimlanguageabilityid',
        prop: 'pimlanguageabilityid',
        dataType: 'GUID',
      },
      {
        name: 'pimlanguageability',
        prop: 'pimlanguageabilityid',
        dataType: 'FONTKEY',
      },
    ]
  }

}