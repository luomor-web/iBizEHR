/**
 * Main_2 部件模型
 *
 * @export
 * @class Main_2Model
 */
export default class Main_2Model {

  /**
  * 获取数据项集合
  *
  * @returns {any[]}
  * @memberof Main_2Model
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
        name: 'pimlanguageabilityname',
        prop: 'pimlanguageabilityname',
        dataType: 'TEXT',
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
        name: 'jlss',
        prop: 'jlss',
        dataType: 'SSCODELIST',
      },
      {
        name: 'fj',
        prop: 'fj',
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